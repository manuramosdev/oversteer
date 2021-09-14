package dev.manuramos.oversteer.domain.repository

import dev.manuramos.oversteer.data.remote.dto.DriverStandingDto
import dev.manuramos.oversteer.data.remote.dto.Race

interface DriverRepository {
    suspend fun getDriverStandings(season: Int): List<DriverStandingDto>

    suspend fun getDriverResults(season: Int, driverId: String): List<Race>
}