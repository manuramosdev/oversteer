package dev.manuramos.oversteer.data.remote.dto

data class Circuit(
    val Location: Location,
    val circuitId: String,
    val circuitName: String,
    val url: String
)