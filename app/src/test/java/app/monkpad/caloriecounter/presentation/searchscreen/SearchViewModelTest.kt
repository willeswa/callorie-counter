package app.monkpad.caloriecounter.presentation.searchscreen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.monkpad.caloriecounter.CalorieCounterApplication
import app.monkpad.caloriecounter.data.local.datasource.CaloriesLocalDataSource
import app.monkpad.caloriecounter.data.remote.datasource.CaloriesRemoteDataSource
import app.monkpad.caloriecounter.data.repositories.CaloriesRepository
import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntries
import app.monkpad.caloriecounter.domain.usecases.GetCalorieEntry
import app.monkpad.caloriecounter.framework.UseCases
import app.monkpad.caloriecounter.presentation.detailscreen.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [30])
class SearchViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testStartCalculating_whenClicked_setsCalculatingStateToTrue() {
        val application = ApplicationProvider.getApplicationContext() as CalorieCounterApplication
        val remote = CaloriesRemoteDataSource()
        val local = CaloriesLocalDataSource(application)
        val repository = CaloriesRepository(remote, local)
        val useCases = UseCases(GetCalorieEntry(repository), GetCalorieEntries(repository))

        //GIVEN a search viewModel
        val viewModel = SearchViewModel(application, useCases)

        //WHEN the Calculate button is called
        viewModel.startCalculating()

        //THEN the calculating state is set to true
        val calculating = viewModel.calculating.getOrAwaitValue()
        assertThat(calculating).isTrue()
    }


    @Test
    fun testFinishCalculating_whenCalculationIsDone_setsCalculationStateToFalse(){
        val application = ApplicationProvider.getApplicationContext() as CalorieCounterApplication
        val remote = CaloriesRemoteDataSource()
        val local = CaloriesLocalDataSource(application)
        val repository = CaloriesRepository(remote, local)
        val useCases = UseCases(GetCalorieEntry(repository), GetCalorieEntries(repository))

        //GIVEN a search viewModel
        val viewModel = SearchViewModel(application, useCases)

        //WHEN calculation is complete
        viewModel.finishCalculating()

        //THEN the calculating state is set to false
        val calculating = viewModel.calculating.getOrAwaitValue()
        assertThat(calculating).isFalse()

    }

}