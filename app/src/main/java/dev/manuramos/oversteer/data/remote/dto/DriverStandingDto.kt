package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingDto(
    val constructors: List<ConstructorDto>,
    val Driver: DriverDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)

fun DriverStandingDto.toDriverStanding(): DriverStanding = DriverStanding(
    position = position.toInt(),
    points = points.toInt(),
    wins = wins.toInt(),
    driver = Driver.toDriver(),
    constructors = constructors.map { it.toConstructor() }

)