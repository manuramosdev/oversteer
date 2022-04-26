package dev.manuramos.oversteer.ui.views.driverStandings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.useCase.GetDriverStandingsUseCase
import dev.manuramos.oversteer.driverStandings
import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import javax.inject.Inject

@Composable
fun DriversScreen(viewModel: DriversStandingsViewModel = hiltViewModel()) =
    ListScreen(viewModel) @Composable { DriverRow(it) }

@HiltViewModel
class DriversStandingsViewModel @Inject constructor(
    getDriversStandingsUseCase: GetDriverStandingsUseCase
) : ListViewModel<DriverStanding>(
    getDriversStandingsUseCase,
)

@Composable
fun DriversList(
    drivers: List<DriverStanding>
) {
    LazyColumn {
        items(drivers) { driverStanding -> DriverRow(driverStanding) }
    }
}

@Preview(showBackground = true)
@Composable
fun StandingsPreview() {
    DriversList(drivers = driverStandings)
}
