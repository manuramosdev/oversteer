package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingDto(
    val Constructors: List<ConstructorDto>,
    val Driver: DriverDto,
    val points: Number,
    val position: String,
    val positionText: String,
    val wins: String
)

fun DriverStandingDto.toDriverStanding(): DriverStanding = DriverStanding(
    position = position.toInt(),
    points = points.toDouble(),
    wins = wins.toInt(),
    driver = Driver.toDriver(),
    constructors = Constructors.map { it.toConstructor() }

)