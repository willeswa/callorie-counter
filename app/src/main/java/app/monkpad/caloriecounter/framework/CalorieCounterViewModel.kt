package app.monkpad.caloriecounter.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import app.monkpad.caloriecounter.CalorieCounterApplication


open class CalorieCounterViewModel(application: Application, protected val useCases: UseCases) :
        AndroidViewModel(application) {
            protected val application: CalorieCounterApplication = getApplication()
}