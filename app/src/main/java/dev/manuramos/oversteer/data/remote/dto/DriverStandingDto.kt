package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.toDomain
import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingDto(
    @SerializedName("Constructors")
    val constructorDtos: List<ConstructorDto>,
    @SerializedName("Driver")
    val driver: DriverDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
) : Dto<DriverStanding> {
    override fun toDomain(): DriverStanding = DriverStanding(
        position = position,
        points = points,
        wins = wins.toInt(),
        driver = driver.toDomain(),
        constructors = constructorDtos.toDomain()
    )
}
