package dev.manuramos.oversteer.ui.views.driverStandings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.manuramos.oversteer.domain.model.Constructor
import dev.manuramos.oversteer.domain.model.Driver
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.driverStandings
import dev.manuramos.oversteer.formula1Bold
import dev.manuramos.oversteer.formula1Regular
import dev.manuramos.oversteer.ui.views.components.Points
import dev.manuramos.oversteer.ui.views.components.Position


@Composable
fun DriverRow(
    driverStanding: DriverStanding,
//    onItemClick: (DriverStanding) -> Unit
) {

    val teamColor = driverStanding.constructors.first().color
    Row(
        modifier = Modifier
            .padding(all = 2.dp)
            .background(teamColor)
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Position(driverStanding.position)
        Spacer(modifier = Modifier.width(4.dp))
        DriverName(driverStanding.driver)
        DriverNumber(driverStanding.driver.permanentNumber?.toString())
        Spacer(modifier = Modifier.width(10.dp))
        DriverConstructors(driverStanding.constructors)
        Spacer(modifier = Modifier.width(12.dp))
        Points(driverStanding.points)
    }
}

@Composable
private fun DriverConstructors(constructors: List<Constructor>) {
    Column(
        Modifier.width(100.dp)
    ) {
        constructors.forEach {
            Text(
                text = it.name,
                fontFamily = formula1Regular
            )
        }
    }
}

@Composable
private fun DriverName(driver: Driver) {
    Column(
        modifier = Modifier
            .width(130.dp)
//            .border(1.dp, color = Color.Black, shape = CircleShape)
    ) {
        Text(
            text = driver.givenName,
            fontFamily = formula1Regular
        )
        Text(
            text = driver.familyName,
            fontSize = 18.sp,
            fontFamily = formula1Bold
        )
    }
}

@Composable
private fun DriverNumber(text: String?) {
    if (text != null) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = formula1Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .border(1.dp, color = Color.Black, shape = CircleShape)
                .padding(all = 3.dp)
                .width(23.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DriverStandingPreview() {
    DriversList(drivers = driverStandings)
}
