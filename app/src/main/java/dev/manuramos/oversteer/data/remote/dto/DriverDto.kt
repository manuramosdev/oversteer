package dev.manuramos.oversteer.data.remote.dto

data class DriverDto(
    val code: String,
    val dateOfBirth: String,
    val driverId: String,
    val familyName: String,
    val givenName: String,
    val nationality: String,
    val permanentNumber: String,
    val url: String
)