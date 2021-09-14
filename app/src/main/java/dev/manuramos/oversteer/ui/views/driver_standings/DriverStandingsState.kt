package dev.manuramos.oversteer.ui.views.driver_standings

import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingsState(
    val isLoading: Boolean = false,
    val driversStandings: List<DriverStanding> = emptyList(),
    val error: String = ""
)