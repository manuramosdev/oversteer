package dev.manuramos.oversteer.data.remote.dto

data class RaceTable(
    val Races: List<Race>,
    val driverId: String,
    val season: String
)