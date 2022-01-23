package app.monkpad.caloriecounter.data.repositories

import app.monkpad.caloriecounter.data.local.datasource.CaloriesLocalDataSource
import app.monkpad.caloriecounter.data.remote.datasource.CaloriesRemoteDataSource
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import kotlinx.coroutines.flow.Flow

class CaloriesRepository(
    private val caloriesRemoteDataSource: CaloriesRemoteDataSource,
    private val caloriesLocalDataSource: CaloriesLocalDataSource
) {
    fun getCachedSearches(): Flow<List<CalorieEntry>> =
        caloriesLocalDataSource.getCaloriesEntries()

    suspend fun getCaloriesForFood(name: String): List<CalorieEntry>? {
        val cachedEntries = caloriesLocalDataSource.getCalorieEntry(name.capitalize())
        return try {
            if (cachedEntries.isEmpty()) {
                caloriesLocalDataSource.addCaloriesEntry(caloriesRemoteDataSource.getCalorieCountFor(
                    name)[0])
                caloriesRemoteDataSource.getCalorieCountFor(name)
            } else {
                cachedEntries
            }
        } catch (e: Exception){
            null
        }
    }

}