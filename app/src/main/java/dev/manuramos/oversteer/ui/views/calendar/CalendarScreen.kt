package dev.manuramos.oversteer.ui.views.calendar

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.domain.use_case.GetCalendarUseCase
import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import javax.inject.Inject

@Composable
fun CalendarScreen(viewModel: CalendarViewModel = hiltViewModel()) =
    ListScreen(viewModel) @Composable { CalendarRow(it) }

@HiltViewModel
class CalendarViewModel @Inject constructor(
    getDriversStandingsUseCase: GetCalendarUseCase
) : ListViewModel<Race>(
    getDriversStandingsUseCase,
)
