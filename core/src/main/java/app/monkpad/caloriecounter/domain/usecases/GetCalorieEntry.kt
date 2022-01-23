package app.monkpad.caloriecounter.domain.usecases

import app.monkpad.caloriecounter.data.repositories.CaloriesRepository
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import kotlinx.coroutines.flow.Flow

class GetCalorieEntry(private val caloriesRepository: CaloriesRepository) {
     suspend operator fun invoke(name: String): List<CalorieEntry>? =
        caloriesRepository.getCaloriesForFood(name)
}