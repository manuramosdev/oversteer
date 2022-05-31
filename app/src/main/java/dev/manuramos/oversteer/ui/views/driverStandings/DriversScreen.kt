package dev.manuramos.oversteer.ui.views.driverStandings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.useCase.GetDriverStandingsUseCase
import dev.manuramos.oversteer.driverStandings

import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import dev.manuramos.oversteer.ui.views.OversteerBottomNavigationBar
import dev.manuramos.oversteer.ui.views.destinations.ConstructorsScreenDestination
import javax.inject.Inject

@Destination
@Composable
fun DriversScreen(navigator: DestinationsNavigator) =
    Scaffold(
        topBar = {
            TopAppBar() {
                Row() {
                    Text(
                        text = "Oversteer", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )


                }
            }
        },
        bottomBar = { OversteerBottomNavigationBar(navigator) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        )
        {
            var viewModel: DriversStandingsViewModel = hiltViewModel()
            ListScreen(viewModel) @Composable { DriverRow(it, navigator) }
        }
    }

@HiltViewModel
class DriversStandingsViewModel @Inject constructor(
    getDriversStandingsUseCase: GetDriverStandingsUseCase
) : ListViewModel<DriverStanding>(
    getDriversStandingsUseCase,
)

@Composable
fun DriversList(
    drivers: List<DriverStanding>
,navigator: DestinationsNavigator
) {
    LazyColumn {
        items(drivers) { driverStanding -> DriverRow(driverStanding,navigator) }
    }
}

