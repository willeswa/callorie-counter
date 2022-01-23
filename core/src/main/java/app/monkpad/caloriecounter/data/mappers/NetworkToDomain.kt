package app.monkpad.caloriecounter.data.mappers

import app.monkpad.caloriecounter.data.remote.models.CaloriesEntryDTO
import app.monkpad.caloriecounter.domain.models.CalorieEntry

internal fun CaloriesEntryDTO.asDomainModel() =
    CalorieEntry(
        foodName,
        foodsImage = null,
        calories,
        sugar,
        fiber,
        serving,
        carbohydrates,
        proteins,
        cholesterol,
        fat,
        fatSaturated,
        potassium,
        sodium
    )