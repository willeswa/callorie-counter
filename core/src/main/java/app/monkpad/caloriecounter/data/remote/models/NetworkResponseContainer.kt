package app.monkpad.caloriecounter.data.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkResponseContainer(
    val items: List<CaloriesEntryDTO>)