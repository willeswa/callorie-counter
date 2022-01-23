package app.monkpad.caloriecounter.interactions

import app.monkpad.caloriecounter.domain.models.CalorieEntry

class CachedEntriesClickListener(val clickListener: (entry: CalorieEntry) -> Unit) {
    fun onCalorieEntreClicked(entry: CalorieEntry) = clickListener(entry)
}