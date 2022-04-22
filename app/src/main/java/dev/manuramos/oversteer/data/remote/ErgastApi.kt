package dev.manuramos.oversteer.data.remote

import dev.manuramos.oversteer.data.remote.dto.ConstructorsStandingsResponse
import dev.manuramos.oversteer.data.remote.dto.DriverResultsResponse
import dev.manuramos.oversteer.data.remote.dto.DriverStandingsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ErgastApi {
    @GET("{season}/driverStandings.json")
    suspend fun getDriversStandings(
        @Path("season") season: Int = Calendar.getInstance().get(Calendar.YEAR)
    ): DriverStandingsResponse

  @GET("{season}/constructorStandings.json")
    suspend fun getConstructorsStandings(
        @Path("season") season: Int = Calendar.getInstance().get(Calendar.YEAR)
    ): ConstructorsStandingsResponse

    @GET("{season}/drivers/{driverId}/results.json")
    suspend fun getDriverResults(
        @Path("season") season: Int,
        @Path("driverId") driverId: String
    ): DriverResultsResponse
}
