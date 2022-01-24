package app.monkpad.caloriecounter.presentation.searchscreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.monkpad.caloriecounter.framework.CalorieCounterViewModel
import app.monkpad.caloriecounter.framework.UseCases

class SearchViewModel(application: Application, useCases: UseCases) :
        CalorieCounterViewModel(application, useCases) {

    private val _calculating = MutableLiveData<Boolean>()
    val calculating: LiveData<Boolean> = _calculating

    fun startCalculating() {
        _calculating.postValue(true)
    }

    fun finishCalculating() {
        _calculating.postValue(false)
    }

}