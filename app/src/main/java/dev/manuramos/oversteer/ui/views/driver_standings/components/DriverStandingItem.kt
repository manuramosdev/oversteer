package dev.manuramos.oversteer.ui.views.driver_standings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.manuramos.oversteer.domain.model.Constructor
import dev.manuramos.oversteer.domain.model.Driver
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.driverStandings
import dev.manuramos.oversteer.formula1Bold
import dev.manuramos.oversteer.formula1Regular


@Composable
fun DriverRow(
    driverStanding: DriverStanding,
//    onItemClick: (DriverStanding) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .background(Color(driverStanding.constructors.first().color))
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldNumber(driverStanding.position.toString())
        Spacer(modifier = Modifier.width(12.dp))
        DriverName(driverStanding.driver)
        BoldNumber(driverStanding.driver.permanentNumber.toString())
        Spacer(modifier = Modifier.width(1.dp))
        DriverConstructors(driverStanding.constructors)
        Spacer(modifier = Modifier.width(12.dp))
        BoldNumber("""${driverStanding.points} p""")
    }
}


@Composable
private fun DriverConstructors(constructors: List<Constructor>) {
    Text(text = constructors.joinToString { it.name })
}

@Composable
private fun DriverName(driver: Driver) {
    Column(modifier = Modifier.width(120.dp)) {
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
private fun BoldNumber(text: String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontFamily = formula1Bold
    )
}

@Preview(showBackground = true)
@Composable
fun DriverStandingPreview() {
    DriverRow(driverStanding = driverStandings.first())
}
