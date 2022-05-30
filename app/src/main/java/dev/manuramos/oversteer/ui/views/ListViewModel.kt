package dev.manuramos.oversteer.ui.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.manuramos.oversteer.common.Resource
import dev.manuramos.oversteer.domain.useCase.GetListUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class ListViewModel<T>(
    private val getListUseCase: GetListUseCase<T>
) : ViewModel() {
    private val _state = mutableStateOf(ListState<T>())
    open val state: State<ListState<T>> = _state

    init {
        getItems()
    }

    private fun getItems() {
        getListUseCase().onEach { result ->
            _state.value = when (result) {
                is Resource.Loading -> ListState(isLoading = true)
                is Resource.Error -> ListState(error = result.message ?: "Known error")
                is Resource.Success -> ListState(items = result.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }
}

// todo not used
data class ListState<T>(
    val isLoading: Boolean = false,
    val items: List<T> = emptyList(),
    val error: String = ""
)
