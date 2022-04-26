package dev.manuramos.oversteer.data.repository

import dev.manuramos.oversteer.data.remote.ErgastApi
import dev.manuramos.oversteer.data.toDomain
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class DriverRepositoryImpl @Inject constructor(
    private val api: ErgastApi
) : DriverRepository {
    override suspend fun getDriverStandings(season: Int) =
        api.getDriversStandings(season).toDomain()

    override suspend fun getConstructorsStandings(season: Int) =
        api.getConstructorsStandings(season).toDomain()

    override suspend fun getCalendar(season: Int) =
        api.getCalendar(season = season).toDomain()
}
