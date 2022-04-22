package dev.manuramos.oversteer.ui.views.driver_standings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.common.Resource
import dev.manuramos.oversteer.domain.use_case.GetDriverStandingsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DriversStandingsViewModel @Inject constructor(
    private val getDriversStandingsUseCase: GetDriverStandingsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DriverStandingsState())
    val state: State<DriverStandingsState> = _state

    init {
        getDriversStandings()
    }

    private fun getDriversStandings() {
        val season = Calendar.getInstance().get(Calendar.YEAR)
        getDriversStandingsUseCase(season).onEach { result ->
            _state.value = when (result) {
                is Resource.Loading -> DriverStandingsState(isLoading = true)
                is Resource.Error -> DriverStandingsState(error = result.message ?: "Known error")
                is Resource.Success -> DriverStandingsState(driversStandings = result.data ?: emptyList())
            }

        }.launchIn(viewModelScope)
    }
}
