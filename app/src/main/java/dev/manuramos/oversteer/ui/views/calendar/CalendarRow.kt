package dev.manuramos.oversteer.ui.views.calendar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.formula1Bold
import dev.manuramos.oversteer.formula1Regular
import dev.manuramos.oversteer.ui.views.components.Position


@Composable
fun CalendarRow(race: Race) {
    Row(
        modifier = Modifier
            .padding(all = 1.dp)
            // todo
//            .background()
            .height(36.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Position(race.round)
        Spacer(modifier = Modifier.width(4.dp))
        RaceName(race)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = race.circuit.circuitName,
            fontFamily = formula1Regular
        )
    }
}

@Composable
private fun RaceName(race: Race) {
    val raceName = race.raceName.replace("Grand Prix", "GP")
    Text(
        text = raceName,
        fontFamily = formula1Bold
    )
}
