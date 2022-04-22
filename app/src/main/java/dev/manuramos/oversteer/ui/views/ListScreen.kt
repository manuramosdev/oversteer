package dev.manuramos.oversteer.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun <T> ListScreen(
    viewModel: ListViewModel<T>,
    row: @Composable (item: T) -> Unit
) =
    LazyColumn {
        val items = viewModel.state.value.items
        items(items) { row(it) }
    }
