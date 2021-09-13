package dev.manuramos.oversteer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.manuramos.oversteer.model.COLORS
import dev.manuramos.oversteer.model.Constructor
import dev.manuramos.oversteer.model.Driver
import dev.manuramos.oversteer.model.DriverStanding

@Composable
fun DriversScreen() {
    DriversList(drivers = FAKE_DATA.driverStandings)
}

@Composable
fun DriversList(
    drivers: List<DriverStanding>
) {
    LazyColumn {
        items(drivers) { driverStanding -> DriverRow(driverStanding) }
    }
}

@Composable
fun DriverRow(driverStanding: DriverStanding) {
    val color = Color(COLORS[driverStanding.Constructors.first().constructorId] ?: 0xFFFFFFFF)
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .background(color)
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldNumber(driverStanding.position.toString())
        Spacer(modifier = Modifier.width(12.dp))
        DriverName(driverStanding.Driver)
        BoldNumber(driverStanding.Driver.permanentNumber.toString())
        Spacer(modifier = Modifier.width(1.dp))
        DriverConstructors(driverStanding.Constructors)
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
            fontSize = 20.sp,
            fontFamily = formula1Bold
        )
    }
}

@Composable
private fun BoldNumber(text: String) {
    Text(
        text = text,
        fontSize = 32.sp,
        fontFamily = formula1Bold
    )
}

@Preview(showBackground = true)
@Composable
fun StandingsPreview() {
    DriversList(drivers = FAKE_DATA.driverStandings)
}
