package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.data
import dev.manuramos.oversteer.domain.model.ConstructorStanding

data class ConstructorsStandingsResponse(
    @SerializedName("MRData")
    val mRData: MRDataConstructorsStandings
): Dto<List<ConstructorStanding>> {
    override val data = mRData.standingsTable.standingsLists.first().constructorStandings.data
}

data class MRDataConstructorsStandings(
    @SerializedName("StandingsTable")
    val standingsTable: StandingsTableConstructorStandings,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class StandingsTableConstructorStandings(
    @SerializedName("StandingsLists")
    val standingsLists: List<StandingsListsConstructorStandings>,
    val season: String
)

data class StandingsListsConstructorStandings(
    @SerializedName("ConstructorStandings")
    val constructorStandings: List<ConstructorStandingDto>,
    val round: String,
    val season: String
)
