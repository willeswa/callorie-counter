package app.monkpad.caloriecounter.data.mappers

import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity
import app.monkpad.caloriecounter.domain.models.CalorieEntry

fun CalorieEntryEntity.asDomainModel() =
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