package app.monkpad.caloriecounter.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import app.monkpad.caloriecounter.CalorieCounterApplication

/**
 * The main ViewModel to be subclassed by every fragment ViewModel.
 */
open class CalorieCounterViewModel(application: Application, protected val useCases: UseCases) :
        AndroidViewModel(application) {
    protected val application: CalorieCounterApplication = getApplication()
}