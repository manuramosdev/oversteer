package dev.manuramos.oversteer.domain.model

import java.util.*

data class Race(
    val circuit: Circuit,
    val firstPractice: Date,
    val qualifying: Date,
    val secondPractice: Date,
    val sprint: Date,
    val thirdPractice: Date,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)

data class Circuit(
    val location: Location,
    val circuitId: String,
    val circuitName: String,
    val url: String
)

data class Location(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
)
