package dev.manuramos.oversteer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
    val driver = driverStanding.driver
    Row {
        Text(text = driver.fullName)
        Text(text = driverStanding.points.toString())
    }
}
