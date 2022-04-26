package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.data
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
    override val data = DriverStanding(
        position = position,
        points = points,
        wins = wins.toInt(),
        driver = driver.data,
        constructors = constructorDtos.data,
    )
}
