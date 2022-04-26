package dev.manuramos.oversteer.domain.useCase

import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class GetCalendarUseCase @Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<Race>(
    getItems = { repository.getCalendar(2022) }
)
