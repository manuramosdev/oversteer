package dev.manuramos.oversteer.domain.useCase

import dev.manuramos.oversteer.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class GetListUseCase<T>(
    val getItems: suspend () -> List<T>
) {
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
