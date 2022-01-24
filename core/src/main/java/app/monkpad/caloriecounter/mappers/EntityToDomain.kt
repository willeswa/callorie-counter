package app.monkpad.caloriecounter.mappers

import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity
import app.monkpad.caloriecounter.domain.models.CalorieEntry

internal fun CalorieEntryEntity.asDomainModel() =
    CalorieEntry(
        foodName,
        foodsImage,
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