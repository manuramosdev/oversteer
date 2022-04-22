package dev.manuramos.oversteer.ui.views.driver_standings

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.use_case.GetDriverStandingsUseCase
import dev.manuramos.oversteer.ui.views.ListViewModel
import javax.inject.Inject

@HiltViewModel
class DriversStandingsViewModel @Inject constructor(
    getDriversStandingsUseCase: GetDriverStandingsUseCase
) : ListViewModel<DriverStanding>(
    getDriversStandingsUseCase,
)
