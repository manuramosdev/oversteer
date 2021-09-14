package dev.manuramos.oversteer.data.remote.dto

data class MRDataX(
    val RaceTable: RaceTable,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)