package dev.manuramos.oversteer.ui.views.driver_standings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.manuramos.oversteer.common.Resource
import dev.manuramos.oversteer.domain.use_case.GetDriverStandingsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class DriversStandingsViewModel @Inject constructor(
    private val getDriversStandingsUseCase: GetDriverStandingsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DriverStandingsState())
    val state: State<DriverStandingsState> = _state

    init {
        getDriversStandings()
    }

    private fun getDriversStandings() {
        getDriversStandingsUseCase(2021).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = DriverStandingsState(isLoading = true)
                }
                is Resource.Error -> {
                    // todo centralized error
                    _state.value = DriverStandingsState(error = result.message ?: "Unknown error")
                }
                is Resource.Success -> {
                    // todo emptyListError?
                    _state.value =
                        DriverStandingsState(driversStandings = result.data ?: emptyList())

                }
            }

        }.launchIn(viewModelScope)
    }
}
