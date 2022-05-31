package dev.manuramos.oversteer.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val driverId: String,
    val givenName: String,
    val familyName: String,
    val nationality: String,
    val permanentNumber: Number?,
    val code: String,
    val url: String,
    val dateOfBirth: String,
):Parcelable {
    val fullName = """$givenName $familyName"""
}

@Parcelize
data class DriverStanding(
    val position: String,
//    "positionText": "21",
    val points: String,
    val wins: Number,
    val driver: Driver,
    val constructors: List<Constructor>,
):Parcelable
