package dev.manuramos.oversteer.ui.views.calendar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.Race
import dev.manuramos.oversteer.domain.useCase.GetCalendarUseCase
import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import dev.manuramos.oversteer.ui.views.OversteerBottomNavigationBar
import javax.inject.Inject

@Destination(start = true)
@Composable
fun CalendarScreen(navigator: DestinationsNavigator) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Row() {
                    Text(
                        text = "Oversteer", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )


                }
            }
        },
        bottomBar = { OversteerBottomNavigationBar(navigator) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        ) {
            var viewModel: CalendarViewModel = hiltViewModel()
            ListScreen(viewModel) @Composable { CalendarRow(it) }
        }
    }
}

@HiltViewModel
class CalendarViewModel @Inject constructor(
    getDriversStandingsUseCase: GetCalendarUseCase
) : ListViewModel<Race>(
    getDriversStandingsUseCase,
)
