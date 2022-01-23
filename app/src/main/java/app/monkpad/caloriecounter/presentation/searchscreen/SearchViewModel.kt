package app.monkpad.caloriecounter.presentation.searchscreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.monkpad.caloriecounter.framework.CalorieCounterViewModel
import app.monkpad.caloriecounter.framework.UseCases

class SearchViewModel(application: Application, useCases: UseCases) :
        CalorieCounterViewModel(application, useCases) {

    private val _foodName = MutableLiveData<String>()
    val foodName: LiveData<String> = _foodName

    private val _calculating = MutableLiveData<Boolean>()
    val calculating: LiveData<Boolean> = _calculating

    private val _calorieCount = MutableLiveData<Double?>()

    fun startCalculating() {
        _calculating.postValue(true)
    }

    fun finishCalculating() {
        _calculating.postValue(false)
    }

}