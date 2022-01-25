package app.monkpad.caloriecounter.mappers

import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity
import app.monkpad.caloriecounter.domain.models.CalorieEntry

private const val UNSPLASH_URL = "https://source.unsplash.com/random/65%C3%9765/?"

internal fun CalorieEntry.asEntityModel(name: String): CalorieEntryEntity =
    CalorieEntryEntity(
        foodName.capitalize(),
        foodsImage = "$UNSPLASH_URL$name",
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
        sodium)