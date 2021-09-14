package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DriverStandingDto(
    val constructors: List<ConstructorDto>,
    @SerializedName("Driver")
    val driver: DriverDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)