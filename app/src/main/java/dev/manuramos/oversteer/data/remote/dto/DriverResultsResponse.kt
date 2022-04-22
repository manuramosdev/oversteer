package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.Race

data class DriverResultsResponse(
    val MRData: MRDataDriverResults
)

data class MRDataDriverResults(
    val RaceTable: RaceTableDto,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class RaceTableDto(
    val Races: List<RaceDto>,
    val driverId: String,
    val season: String
)
data class RaceDto(
    val Circuit: CircuitDto,
    val Results: List<RaceResultDto>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
): Dto<Race> {
    override fun toDomain(): Race = Race(name = raceName)
}

data class RaceResultDto(
    val Constructor: ConstructorDto,
    val Driver: DriverDto,
    val FastestLap: FastestLapDto,
    val Time: TimeWithMillisDto,
    val grid: String,
    val laps: String,
    val number: String,
    val points: String,
    val position: String,
    val positionText: String,
    val status: String
)

data class FastestLapDto(
    val AverageSpeed: AverageSpeedDto,
    val Time: TimeDto,
    val lap: String,
    val rank: String
)

data class AverageSpeedDto(
    val speed: String,
    val units: String
)

data class TimeDto(
    val time: String
)

data class CircuitDto(
    val Location: LocationDto,
    val circuitId: String,
    val circuitName: String,
    val url: String
)

data class LocationDto(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
)

data class TimeWithMillisDto(
    val millis: String,
    val time: String
)
