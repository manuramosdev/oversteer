package dev.manuramos.oversteer.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.domain.repository.DriverRepository
import dev.manuramos.oversteer.formula1Bold
import dev.manuramos.oversteer.formula1Regular
import dev.manuramos.oversteer.ui.views.driver_standings.components.Points
import dev.manuramos.oversteer.ui.views.driver_standings.components.Position
import javax.inject.Inject

@Composable
fun ConstructorsScreen(viewModel: ConstructorsStandingsViewModel = hiltViewModel()) =
    ListScreen(viewModel) @Composable {  ConstructorRow(it) }

@Composable
fun ConstructorRow(constructorStanding: ConstructorStanding) {
    val teamColor = constructorStanding.constructor.color
    Row(
        modifier = Modifier
            .padding(all = 4.dp)
            .background(teamColor)
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Position(constructorStanding.position)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = constructorStanding.constructor.name,
            fontFamily = formula1Bold
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = constructorStanding.constructor.nationality,
            fontFamily = formula1Regular
        )
        Spacer(modifier = Modifier.width(12.dp))
        Points(constructorStanding.points)
    }
}

@HiltViewModel
class ConstructorsStandingsViewModel @Inject constructor(
    getConstructorStandingsUseCase: GetConstructorStandingsUseCase
): ListViewModel<ConstructorStanding>(getConstructorStandingsUseCase)

class GetConstructorStandingsUseCase@Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<ConstructorStanding>(
    getItems = { repository.getConstructorsStandings(2022) }
)
