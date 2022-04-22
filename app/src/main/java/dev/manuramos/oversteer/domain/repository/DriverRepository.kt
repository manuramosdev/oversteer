package dev.manuramos.oversteer.domain.repository

import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.model.Race

interface DriverRepository {
    suspend fun getDriverStandings(season: Int): List<DriverStanding>

    suspend fun getDriverResults(season: Int, driverId: String): List<Race>
}