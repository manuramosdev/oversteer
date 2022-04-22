package dev.manuramos.oversteer.data.repository

import dev.manuramos.oversteer.data.remote.ErgastApi
import dev.manuramos.oversteer.data.toDomain
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class DriverRepositoryImpl @Inject constructor(
    private val api: ErgastApi
) : DriverRepository {
    override suspend fun getDriverStandings(season: Int): List<DriverStanding> {
        return api.getDriversStandings(season = season).MRData.StandingsTable.StandingsLists.first().DriverStandings
            .toDomain()
    }

    override suspend fun getDriverResults(season: Int, driverId: String): List<Race> {
        return api.getDriverResults(season = season, driverId = driverId).MRData.RaceTable.Races
            .toDomain()
    }
}
