package app.monkpad.caloriecounter

import android.app.Application
import app.monkpad.caloriecounter.data.local.datasource.CaloriesLocalDataSource
import app.monkpad.caloriecounter.data.remote.datasource.CaloriesRemoteDataSource
import app.monkpad.caloriecounter.data.repositories.CaloriesRepository
import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntries
import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntry
import app.monkpad.caloriecounter.framework.CalorieCounterViewModelFactory
import app.monkpad.caloriecounter.framework.UseCases

/**
 * Custom application class to customize initialization of our app.
 * This is where we do our manual dependency injection and load the ViewModelFactory.
 * Also, if we ever were to set up a cronjob, this would be a good place to init it.
 */
class CalorieCounterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val remoteDataSource = CaloriesRemoteDataSource()
        val localDataSource = CaloriesLocalDataSource(applicationContext)

        val repository = CaloriesRepository(remoteDataSource, localDataSource)

        CalorieCounterViewModelFactory.inject(
            this,
            UseCases(
                GetCalorieEntry(repository),
                GetCalorieEntries(repository))
        )

    }
}