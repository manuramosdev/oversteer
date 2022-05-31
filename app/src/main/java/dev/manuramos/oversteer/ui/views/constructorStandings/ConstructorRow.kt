package dev.manuramos.oversteer.ui.views.constructorStandings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.formula1Bold
import dev.manuramos.oversteer.formula1Regular
import dev.manuramos.oversteer.ui.views.components.Points
import dev.manuramos.oversteer.ui.views.components.Position


@Composable
fun ConstructorRow(constructorStanding: ConstructorStanding) {
    val teamColor = constructorStanding.constructor.color
    Row(
        modifier = Modifier
            .padding(all = 2.dp)
            .background(teamColor)
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Position(constructorStanding.position, Color.White)
        Spacer(modifier = Modifier.width(4.dp))
        ConstructorName(constructorStanding)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = constructorStanding.constructor.nationality,
            fontFamily = formula1Regular,color = Color.White
        )
        Spacer(modifier = Modifier.width(12.dp))
        Points(constructorStanding.points)
    }
}

@Composable
private fun ConstructorName(constructorStanding: ConstructorStanding) {
    val name = constructorStanding.constructor.name.replace(
        " F1 Team", ""
    )
    Text(
        text = name,
        fontFamily = formula1Bold,
        color = Color.White
    )
}
