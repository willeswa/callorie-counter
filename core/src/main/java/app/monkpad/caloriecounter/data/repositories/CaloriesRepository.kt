package app.monkpad.caloriecounter.data.repositories

import app.monkpad.caloriecounter.data.local.datasource.CaloriesLocalDataSource
import app.monkpad.caloriecounter.data.remote.datasource.CaloriesRemoteDataSource

class CaloriesRepository(
    private val caloriesRemoteDataSource: CaloriesRemoteDataSource,
    private val caloriesLocalDataSource: CaloriesLocalDataSource
) {
}