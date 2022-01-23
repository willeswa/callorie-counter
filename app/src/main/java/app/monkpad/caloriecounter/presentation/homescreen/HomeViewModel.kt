package app.monkpad.caloriecounter.presentation.homescreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.framework.CalorieCounterViewModel
import app.monkpad.caloriecounter.framework.UseCases

class HomeViewModel(application: Application, useCases: UseCases) :
        CalorieCounterViewModel(application, useCases) {

    val cachedEntries: LiveData<List<CalorieEntry>> =
        useCases.getCalorieEntries().asLiveData()

}