package dev.manuramos.oversteer.data.remote.dto

data class Race(
    val Circuit: Circuit,
    val Results: List<ResultDto>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)