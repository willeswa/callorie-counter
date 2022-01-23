package app.monkpad.caloriecounter.data.remote.datasource

import android.content.Context
import app.monkpad.caloriecounter.data.mappers.asDomainModel
import app.monkpad.caloriecounter.data.remote.api.CaloriesApi
import app.monkpad.caloriecounter.domain.models.CalorieEntry

class CaloriesRemoteDataSource() {
    suspend fun getCalorieCountFor(food: String): List<CalorieEntry> =
        CaloriesApi.retrofitService.getRemoteCalories(food).items.map { it.asDomainModel() }

}