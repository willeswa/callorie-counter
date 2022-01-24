package app.monkpad.caloriecounter.presentation.detailscreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.framework.CalorieCounterViewModel
import app.monkpad.caloriecounter.framework.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(application: Application, useCases: UseCases) :
        CalorieCounterViewModel(application, useCases) {
    var isDetailedOn = false

    private val _calorieEntry = MutableLiveData<List<CalorieEntry>?>()
    val calorieEntry: LiveData<List<CalorieEntry>?> = _calorieEntry

    private val _reset = MutableLiveData<Boolean>()
    val reset: LiveData<Boolean> = _reset

    private val _detailView = MutableLiveData<Boolean>()
    val detailView: LiveData<Boolean> = _detailView

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    fun calculateCalories(food: String) {
      viewModelScope.launch {
          withContext(Dispatchers.IO){
              _calorieEntry.postValue(useCases.getCalorieEntry(food))
          }
          _loading.postValue(false)
      }
    }

    fun startResetting(){
        _reset.postValue(true)
    }

    fun finishResetting(){
        _reset.postValue(false)
    }

    fun toggleDetailView(){
        _detailView.postValue(!isDetailedOn)
        isDetailedOn = !isDetailedOn
    }
}