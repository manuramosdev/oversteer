package dev.manuramos.oversteer.ui.views.constructorStandings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.domain.useCase.GetConstructorStandingsUseCase
import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import dev.manuramos.oversteer.ui.views.OversteerBottomNavigationBar
import javax.inject.Inject

@Destination
@Composable
fun ConstructorsScreen(navigator: DestinationsNavigator) =
       Scaffold(
        topBar = {
            TopAppBar() {
                Row() {
                    Text(
                        text = "SportsDataApp", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )


                }
            }
        },
        bottomBar = { OversteerBottomNavigationBar(navigator) }
    ) {
           var viewModel: ConstructorsStandingsViewModel = hiltViewModel()
           ListScreen(viewModel) @Composable { ConstructorRow(it) }
  }
@HiltViewModel
class ConstructorsStandingsViewModel @Inject constructor(
    getConstructorStandingsUseCase: GetConstructorStandingsUseCase
) : ListViewModel<ConstructorStanding>(getConstructorStandingsUseCase)

