package app.monkpad.caloriecounter.data.local.datasource

import android.content.Context
import app.monkpad.caloriecounter.data.local.database.CaloriesCounterDatabase
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.mappers.asDomainModel
import app.monkpad.caloriecounter.mappers.asEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CaloriesLocalDataSource(context: Context) {
    private val caloriesDao = CaloriesCounterDatabase.getDatabase(context).caloriesDao()

    fun getCaloriesEntries(): Flow<List<CalorieEntry>> =
        caloriesDao.getCaloriesEntries().map { it.map { cal -> cal.asDomainModel() } }

    suspend fun getCalorieEntry(foodName: String): List<CalorieEntry> =
        caloriesDao.getCalorieEntry(foodName).map { it.asDomainModel() }

    suspend fun addCaloriesEntry(calorieEntry: CalorieEntry) =
        caloriesDao.addCaloriesEntry(calorieEntry.asEntityModel(calorieEntry.foodName))

}