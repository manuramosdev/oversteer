package dev.manuramos.oversteer.domain.use_case

import dev.manuramos.oversteer.common.Resource
import dev.manuramos.oversteer.data.remote.dto.toDriverStanding
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.domain.repository.DriverRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDriverStandingsUseCase @Inject constructor(
    private val repository: DriverRepository
) {
    operator fun invoke(season: Int): Flow<Resource<List<DriverStanding>>> =
        flow {
            try {
                emit(Resource.Loading<List<DriverStanding>>())
                val driverStandings =
                    repository.getDriverStandings(season = season).map { it.toDriverStanding() }
                emit(Resource.Success(driverStandings))

            } catch (e: HttpException) {
                emit(
                    Resource.Error<List<DriverStanding>>(
                        e.localizedMessage ?: "An unexpected error occurred"
                    )
                )
            } catch (e: IOException) {
                // todo database?
                emit(Resource.Error<List<DriverStanding>>("Couldn't reach server. Check your internet connection."))
            }
        }
}
