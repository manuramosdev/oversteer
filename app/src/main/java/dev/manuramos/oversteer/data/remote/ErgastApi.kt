package dev.manuramos.oversteer.data.remote

import dev.manuramos.oversteer.domain.model.DriverStanding
import retrofit2.http.GET

class StandingsResponse(val MRData: MRDataStandings)
data class MRDataStandings( val StandingsTable: StandingsTable)
data class StandingsTable(val season: Int, val StandingsLists: List<StandingsList>)
data class StandingsList(val season: Int, val round: Int, val DriverStandings: List<DriverStanding>)

interface ErgastApi {
    @GET("2021/driverStandings.json")
    suspend fun getDriverStandings(): StandingsResponse
}
