package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.toDomain
import dev.manuramos.oversteer.domain.model.DriverStanding

data class DriverStandingsResponse(
    @SerializedName("MRData")
    val mRData: MRDataDriverStandings
) : Dto<List<DriverStanding>> {
    override fun toDomain(): List<DriverStanding> =
        mRData.standingsTable.standingsLists.first().driverStandings.toDomain()
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
