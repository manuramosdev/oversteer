package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.Driver

data class DriverDto(
    val code: String,
    val dateOfBirth: String,
    val driverId: String,
    val familyName: String,
    val givenName: String,
    val nationality: String,
    val permanentNumber: String?,
    val url: String
) : Dto<Driver> {
    override val data = Driver(
        driverId = driverId,
        givenName = givenName,
        familyName = familyName,
        nationality = nationality,
        // todo catch exception
        permanentNumber = permanentNumber?.toInt(),
        code = code,
        url = url,
        dateOfBirth = dateOfBirth,
    )
}
