package dev.manuramos.oversteer.domain.use_case

import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class GetDriverStandingsUseCase @Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<DriverStanding>(
    getItems = { repository.getDriverStandings(2022) }
)
