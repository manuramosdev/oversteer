package dev.manuramos.oversteer.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class Race(
    val circuit: Circuit,
    val firstPractice: Date,
    val qualifying: Date,
    val secondPractice: Date,
    val sprint: Date?,
    val thirdPractice: Date?,
    val race: Date,
    val raceName: String,
    val round: String,
    val season: String,
    val url: String
): Parcelable

@Parcelize
data class Circuit(
    val location: Location,
    val circuitId: String,
    val circuitName: String,
    val url: String
):Parcelable

@Parcelize
data class Location(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
)
:Parcelable
