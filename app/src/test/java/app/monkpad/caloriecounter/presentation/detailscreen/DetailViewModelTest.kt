package app.monkpad.caloriecounter.presentation.detailscreen

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
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [30])
class DetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun startResetting_resetButtonClicked_resetStateTrue() {
        val application = ApplicationProvider.getApplicationContext() as CalorieCounterApplication
        val remote = CaloriesRemoteDataSource()
        val local = CaloriesLocalDataSource(application)
        val repository = CaloriesRepository(remote, local)
        val useCases = UseCases(GetCalorieEntry(repository), GetCalorieEntries(repository))

        //GIVEN a fresh detailedViewViewModel
        val viewModel = DetailViewModel(application, useCases)

        //WHEN when the reset button is clicked
        viewModel.startResetting()

        //THEN then the reset state should be set to true
        val value = viewModel.reset.getOrAwaitValue()
        assertThat(value).isTrue()
    }

    @Test
    fun stopResetting_resetDone_resetStateFalse() {
        val application = ApplicationProvider.getApplicationContext() as CalorieCounterApplication
        val remote = CaloriesRemoteDataSource()
        val local = CaloriesLocalDataSource(application)
        val repository = CaloriesRepository(remote, local)
        val useCases = UseCases(GetCalorieEntry(repository), GetCalorieEntries(repository))

        //GIVEN a ViewModel with reset state set to true
        val viewModel = DetailViewModel(application, useCases)
        viewModel.startResetting()

        //WHEN the resetting is complete
        viewModel.finishResetting()

        //THEN the reset state should be set to false
        val value = viewModel.reset.getOrAwaitValue()
        assertThat(value).isFalse()

    }

    @Test
    fun toggleDetailView_togglesDetailView_OnAndOff() {
        val application = ApplicationProvider.getApplicationContext() as CalorieCounterApplication
        val remote = CaloriesRemoteDataSource()
        val local = CaloriesLocalDataSource(application)
        val repository = CaloriesRepository(remote, local)
        val useCases = UseCases(GetCalorieEntry(repository), GetCalorieEntries(repository))

        //GIVEN a ViewModel with state to manage detail view
        val viewModel = DetailViewModel(application, useCases)

        //WHEN toggleDetailView is called
        viewModel.toggleDetailView()

        //THEN details view is on
        val detailsView = viewModel.detailView.getOrAwaitValue()
        assertThat(detailsView).isTrue()

    }
}