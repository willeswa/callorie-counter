package app.monkpad.caloriecounter.data.repositories

import app.monkpad.caloriecounter.data.local.datasource.CaloriesLocalDataSource
import app.monkpad.caloriecounter.data.remote.datasource.CaloriesRemoteDataSource
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import kotlinx.coroutines.flow.Flow

/**
 * Our only repository to expose the data to other layers.
 * Also, reconciles the differences between local and remote data.
 */
class CaloriesRepository(
    private val caloriesRemoteDataSource: CaloriesRemoteDataSource,
    private val caloriesLocalDataSource: CaloriesLocalDataSource
) {
    fun getCachedSearches(): Flow<List<CalorieEntry>> =
        caloriesLocalDataSource.getCaloriesEntries()

    suspend fun getCaloriesForFood(name: String): List<CalorieEntry>? {

        //We are taking an offline first approach; so first we query the local data.
        val cachedEntries = caloriesLocalDataSource.getCalorieEntry(name)

        return try {
            //If no entries by this name were found, create and return them.
            if (cachedEntries.isEmpty()) {
                caloriesLocalDataSource.addCaloriesEntry(caloriesRemoteDataSource.getCalorieCountFor(
                    name)[0])
                caloriesRemoteDataSource.getCalorieCountFor(name)
            } else {
                //Otherwise, just return the cached data
                cachedEntries
            }
        } catch (e: Exception){
            //If anything goes wrong, return null.
            null
        }
    }

}