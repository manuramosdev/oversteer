package dev.manuramos.oversteer.data.repository

import dev.manuramos.oversteer.data.remote.ErgastApi
import dev.manuramos.oversteer.data.remote.dto.DriverStandingDto
import dev.manuramos.oversteer.data.remote.dto.Race
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject


class DriverRepositoryImpl @Inject constructor(
    private val api: ErgastApi
) : DriverRepository {
    override suspend fun getDriverStandings(season: Int): List<DriverStandingDto> {
        return api.getDriversStandings(season).MRData.StandingsTable.StandingsLists.first().driverStandingDtos
    }

    override suspend fun getDriverResults(season: Int, driverId: String): List<Race> {
        return api.getDriverResults(season = season, driverId = driverId).MRData.RaceTable.Races
    }
}