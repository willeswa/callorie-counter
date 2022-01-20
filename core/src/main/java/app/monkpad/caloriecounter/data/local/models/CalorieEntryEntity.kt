package app.monkpad.caloriecounter.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calorie_entries")
data class CalorieEntryEntity(
    @PrimaryKey
    @ColumnInfo(name = "food_name") val foodName: String,
    @ColumnInfo(name = "food_image") val foodsImage: String,
    val calories: Double,
    val sugar: Double?,
    val fiber: Double?,
    val serving: Double?,
    val carbohydrates: Double?,
    val proteins: Double?,
    val cholesterol: Double?,
    val fat: Double?,
    @ColumnInfo(name = "fat_saturated") val fatSaturated: Double?,
    val potassium: Double?,
    val sodium: Double?
)