package dev.manuramos.oversteer.domain.useCase

import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class GetConstructorStandingsUseCase @Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<ConstructorStanding>(
    getItems = { repository.getConstructorsStandings(2022) }
)
