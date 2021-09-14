package dev.manuramos.oversteer.data.remote.dto

data class StandingsLists(
    val driverStandingDtos: List<DriverStandingDto>,
    val round: String,
    val season: String
)