package dev.manuramos.oversteer.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun <T> ListScreen(
    viewModel: ListViewModel<T>,
    row: @Composable (item: T) -> Unit
) =
    LazyColumn {
        val items = viewModel.state.value.items
        items(items) { row(it) }
    }
