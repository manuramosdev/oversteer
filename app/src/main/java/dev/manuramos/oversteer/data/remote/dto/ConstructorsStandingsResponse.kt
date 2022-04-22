package dev.manuramos.oversteer.data.remote.dto

data class ConstructorsStandingsResponse(
    val MRData: MRDataConstructorsStandings
)

data class MRDataConstructorsStandings(
    val StandingsTable: StandingsTableConstructorStandings,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class StandingsTableConstructorStandings(
    val StandingsLists: List<StandingsListsConstructorStandings>,
    val season: String
)

data class StandingsListsConstructorStandings(
    val ConstructorStandings: List<ConstructorStandingDto>,
    val round: String,
    val season: String
)
