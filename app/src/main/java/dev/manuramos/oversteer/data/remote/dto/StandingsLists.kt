package dev.manuramos.oversteer.data.remote.dto

data class StandingsLists(
    val DriverStandings: List<DriverStandingDto>,
    val round: String,
    val season: String
)