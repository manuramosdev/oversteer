package dev.manuramos.oversteer.data.remote.dto

data class DriverStandingsResponse(
    val MRData: MRDataDriverStandings
)

data class MRDataDriverStandings(
    val StandingsTable: StandingsTable,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class StandingsTable(
    val StandingsLists: List<StandingsLists>,
    val season: String
)

data class StandingsLists(
    val DriverStandings: List<DriverStandingDto>,
    val round: String,
    val season: String
)
