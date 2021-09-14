package dev.manuramos.oversteer.data.remote

import dev.manuramos.oversteer.data.remote.dto.DriverResultsResponse
import dev.manuramos.oversteer.data.remote.dto.DriverStandingsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ErgastApi {
    @GET("{season}/driverStandings.json")
    suspend fun getDriversStandings(@Path("season") season: Int): DriverStandingsResponse

    @GET("{season}/drivers/{driverId}/results.json")
    suspend fun getDriverResults(
        @Path("season") season: Int,
        @Path("driverId") driverId: String
    ): DriverResultsResponse
}
