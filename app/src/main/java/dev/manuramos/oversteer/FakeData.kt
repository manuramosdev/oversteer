package dev.manuramos.oversteer

import dev.manuramos.oversteer.model.Constructor
import dev.manuramos.oversteer.model.Driver
import dev.manuramos.oversteer.model.DriverStanding
import java.util.*

object FAKE_DATA {
    val hamilton = Driver("hamilton", "Lewis", "Hamilton", "British", 44, "HAM", "", Date())
    val bottas = Driver("bottas", "Valtteri", "Bottas", "Finnish", 77, "BOT", "", Date())
    val russell = Driver("russell", "George", "Russell", "British", 63, "RUS", "", Date())
    val sainz = Driver("sainz", "Carlos", "Sainz", "Spanish", 55, "SAI", "", Date())

    val mclaren = Constructor("mclaren", "", "McLaren", "British")
    val ferrari = Constructor("ferrari", "", "Ferrari", "Italian")
    val williams = Constructor("williams", "", "Williams", "British")
    val driverStandings: List<DriverStanding> = listOf(
        DriverStanding(1, 200, 5, hamilton, listOf(mclaren)),
        DriverStanding(2, 150, 4, bottas, listOf(mclaren)),
        DriverStanding(3, 120, 5, russell, listOf(williams)),
        DriverStanding(4, 80, 5, sainz, listOf(ferrari)),
    )
}