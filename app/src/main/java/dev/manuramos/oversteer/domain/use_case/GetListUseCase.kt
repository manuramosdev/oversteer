package dev.manuramos.oversteer.domain.use_case

import dev.manuramos.oversteer.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
