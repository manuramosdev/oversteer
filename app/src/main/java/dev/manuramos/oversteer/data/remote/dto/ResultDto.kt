package dev.manuramos.oversteer.data.remote.dto

data class ResultDto(
    val Constructor: ConstructorDto,
    val Driver: DriverDto,
    val FastestLap: FastestLap,
    val Time: TimeX,
    val grid: String,
    val laps: String,
    val number: String,
    val points: String,
    val position: String,
    val positionText: String,
    val status: String
)