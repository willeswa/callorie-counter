package app.monkpad.caloriecounter.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaloriesEntryDTO(
    @Json(name = "name") val foodName: String,
    val calories: Double,
    @Json(name = "sugar_g") val sugar: Double,
    @Json(name = "fiber_g") val fiber: Double?,
    @Json(name = "serving_size_g") val serving: Double?,
    @Json(name = "carbohydrates_total_g") val carbohydrates: Double?,
    @Json(name = "protein_g") val proteins: Double?,
    @Json(name = "cholesterol_mg") val cholesterol: Double?,
    @Json(name = "fat_total_g") val fat: Double?,
    @Json(name = "fat_saturated_g") val fatSaturated: Double?,
    @Json(name = "potassium_mg") val potassium: Double?,
    @Json(name = "sodium_mg") val sodium: Double?)