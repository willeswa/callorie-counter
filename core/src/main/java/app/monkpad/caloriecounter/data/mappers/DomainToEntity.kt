package app.monkpad.caloriecounter.data.mappers

import app.monkpad.caloriecounter.data.local.models.CalorieEntryEntity
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import java.util.*

fun CalorieEntry.asEntityModel(name:String): CalorieEntryEntity =
    CalorieEntryEntity(
        foodName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
        foodsImage = "https://source.unsplash.com/random/65%C3%9765/?$name",
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