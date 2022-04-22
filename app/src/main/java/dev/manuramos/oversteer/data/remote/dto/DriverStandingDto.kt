package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.toDomain
import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingDto(
    val Constructors: List<ConstructorDto>,
    val Driver: DriverDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
) : Dto<DriverStanding> {
    override fun toDomain(): DriverStanding = DriverStanding(
        position = position,
        points = points,
        wins = wins.toInt(),
        driver = Driver.toDomain(),
        constructors = Constructors.toDomain()
    )
}
