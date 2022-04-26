package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.data
import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingsResponse(
    @SerializedName("MRData")
    val mRData: MRDataDriverStandings
) : Dto<List<DriverStanding>> {
    override val data = mRData.standingsTable.standingsLists.first().driverStandings.data
}

data class MRDataDriverStandings(
    @SerializedName("StandingsTable")
    val standingsTable: StandingsTable,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class StandingsTable(
    @SerializedName("StandingsLists")
    val standingsLists: List<StandingsLists>,
    val season: String
)

data class StandingsLists(
    @SerializedName("DriverStandings")
    val driverStandings: List<DriverStandingDto>,
    val round: String,
    val season: String
)
