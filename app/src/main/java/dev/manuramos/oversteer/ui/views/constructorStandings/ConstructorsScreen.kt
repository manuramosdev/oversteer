package dev.manuramos.oversteer.ui.views.constructorStandings

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.manuramos.oversteer.domain.model.ConstructorStanding
import dev.manuramos.oversteer.domain.useCase.GetConstructorStandingsUseCase
import dev.manuramos.oversteer.ui.views.ListScreen
import dev.manuramos.oversteer.ui.views.ListViewModel
import javax.inject.Inject

@Composable
fun ConstructorsScreen(viewModel: ConstructorsStandingsViewModel = hiltViewModel()) =
    ListScreen(viewModel) @Composable { ConstructorRow(it) }

@HiltViewModel
class ConstructorsStandingsViewModel @Inject constructor(
    getConstructorStandingsUseCase: GetConstructorStandingsUseCase
) : ListViewModel<ConstructorStanding>(getConstructorStandingsUseCase)

