package app.monkpad.caloriecounter.framework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Our Fragment ViewModels will need to be injected with UseCases
 * to facilitate user interaction. For this to happen, we use the Factory pattern
 * to initialize our main ViewModel and enforce every ViewModel that uses this Factory
 * to subclass the CalorieCounterViewModel.
 *
 * We are using an object instead of a class to allow use of Static Fields.
 * This is more of a preference, really.
 */
object CalorieCounterViewModelFactory : ViewModelProvider.Factory {

    lateinit var application: Application
    lateinit var useCases: UseCases

    fun inject(application: Application, useCases: UseCases) {
        CalorieCounterViewModelFactory.application = application
        CalorieCounterViewModelFactory.useCases = useCases
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (CalorieCounterViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, UseCases::class.java)
                .newInstance(application, useCases)
        } else {
            throw IllegalStateException("ViewModel must inherit from CalorieCounterViewModel")
        }
    }
}