package dev.manuramos.oversteer.data.remote.dto

data class FastestLap(
    val AverageSpeed: AverageSpeed,
    val Time: Time,
    val lap: String,
    val rank: String
)