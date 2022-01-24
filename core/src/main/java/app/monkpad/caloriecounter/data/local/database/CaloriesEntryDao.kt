package app.monkpad.caloriecounter.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CaloriesEntryDao {

    @Query("SELECT * FROM calorie_entries")
    fun getCaloriesEntries(): Flow<List<CalorieEntryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCaloriesEntry(vararg caloriesEntry: CalorieEntryEntity)

    @Query("SELECT * FROM calorie_entries WHERE food_name=:foodName")
    suspend fun getCalorieEntry(foodName: String): List<CalorieEntryEntity>

}