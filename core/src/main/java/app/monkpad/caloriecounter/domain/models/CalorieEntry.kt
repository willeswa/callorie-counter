package app.monkpad.caloriecounter.domain.models

data class CalorieEntry(
    val foodName: String,
    val foodsImage: String,
    val calories: Double,
    val sugar: Double?,
    val fiber: Double?,
    val serving: Double?,
    val carbohydrates: Double?,
    val proteins: Double?,
    val cholesterol: Double?,
    val fat: Double?,
    val fatSaturated: Double?,
    val potassium: Double?,
    val sodium: Double?
)