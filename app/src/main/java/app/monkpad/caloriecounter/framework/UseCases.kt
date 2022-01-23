package app.monkpad.caloriecounter.framework

import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntries
import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntry

/**
 * A holder class to expose the useCases.
 * A mere preference over the interfacing approach.
 */
class UseCases(
    val getCalorieEntry: GetCalorieEntry,
    val getCalorieEntries: GetCalorieEntries
)