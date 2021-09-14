package dev.manuramos.oversteer

import dev.manuramos.oversteer.domain.model.Constructor
import dev.manuramos.oversteer.domain.model.Driver
import dev.manuramos.oversteer.domain.model.DriverStanding

val hamilton = Driver("hamilton", "Lewis", "Hamilton", "British", 44, "HAM", "", "")
val bottas = Driver("bottas", "Valtteri", "Bottas", "Finnish", 77, "BOT", "", "")
val russell = Driver("russell", "George", "Russell", "British", 63, "RUS", "", "")
val sainz = Driver("sainz", "Carlos", "Sainz", "Spanish", 55, "SAI", "", "")
val alonso06 = Driver("alonso", "Fernando", "Alonso", "Spanish", 14, "ALO", "", "")

val mercedes = Constructor("mercedes", "", "Mercedes", "British")
val ferrari = Constructor("ferrari", "", "Ferrari", "Italian")
val williams = Constructor("williams", "", "Williams", "British")
val renault = Constructor("renault", "", "Renault", "French")
val driverStandings: List<DriverStanding> = listOf(
    DriverStanding(1, 200, 5, hamilton, listOf(mercedes)),
    DriverStanding(2, 150, 4, bottas, listOf(mercedes)),
    DriverStanding(3, 120, 3, russell, listOf(williams, mercedes)),
    DriverStanding(4, 80, 2, sainz, listOf(ferrari)),
    DriverStanding(5, 55, 1, alonso06, listOf(renault)),
)
