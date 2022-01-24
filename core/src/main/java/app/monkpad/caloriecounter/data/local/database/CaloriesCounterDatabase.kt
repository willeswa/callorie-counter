package app.monkpad.caloriecounter.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity

@Database(
    version = 1,
    entities = [CalorieEntryEntity::class],
    exportSchema = false)
internal abstract class CaloriesCounterDatabase : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: CaloriesCounterDatabase
        private const val DATABASE_NAME = "calories_counter"

        fun getDatabase(context: Context): CaloriesCounterDatabase {
            synchronized(CaloriesCounterDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CaloriesCounterDatabase::class.java,
                        DATABASE_NAME
                    ).build()

                }
            }
            return INSTANCE
        }
    }

    abstract fun caloriesDao(): CaloriesEntryDao
}