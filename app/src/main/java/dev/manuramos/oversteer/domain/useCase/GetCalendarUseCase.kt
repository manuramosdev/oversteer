package dev.manuramos.oversteer.domain.use_case

import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.domain.repository.DriverRepository
import javax.inject.Inject

class GetCalendarUseCase @Inject constructor(
    private val repository: DriverRepository,
): GetListUseCase<Race>(
    getItems = { repository.getCalendar(2022) }
)
