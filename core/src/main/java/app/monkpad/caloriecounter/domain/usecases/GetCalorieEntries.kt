package app.monkpad.caloriecounter.domain.usecases

import app.monkpad.caloriecounter.data.repositories.CaloriesRepository
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import kotlinx.coroutines.flow.Flow

class GetCalorieEntries(private val repository: CaloriesRepository) {
    operator fun invoke(): Flow<List<CalorieEntry>> =
        repository.getCachedSearches()
}