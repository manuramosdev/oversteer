package dev.manuramos.oversteer.ui.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.manuramos.oversteer.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class ListViewModel<T>(
    private val getListUseCase: GetListUseCase<T>
) : ViewModel() {
    private val _state = mutableStateOf(ListState<T>())
    open val state: State<ListState<T>> = _state

    init {
        getLists()
    }

    private fun getLists() {
        getListUseCase().onEach { result ->
            _state.value = when (result) {
                is Resource.Loading -> ListState(isLoading = true)
                is Resource.Error -> ListState(error = result.message ?: "Known error")
                is Resource.Success -> ListState(items = result.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }

    // todo centralized error
    // todo emptyListError?
}

open class GetListUseCase<T>(
    val getItems: suspend () -> List<T>
) {

    // todo errors
    // todo database?
    operator fun invoke(): Flow<Resource<List<T>>> =
        flow {
            try {
                emit(Resource.Loading())
                val items = getItems()
                emit(Resource.Success(items))
            } catch (e: Exception) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection."))
            }
        }
}

data class ListState<T>(
    val isLoading: Boolean = false,
    val items: List<T> = emptyList(),
    val error: String = ""
)
