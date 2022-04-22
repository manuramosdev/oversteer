package dev.manuramos.oversteer.domain.use_case

import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class GetConstructorStandingsUseCase @Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<ConstructorStanding>(
    getItems = { repository.getConstructorsStandings(2022) }
)
