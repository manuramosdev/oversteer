package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.Circuit
import dev.manuramos.oversteer.domain.model.Location

data class DriverResultsResponse(
    @SerializedName("MRData")
    val mRData: MRDataDriverResults
)

data class MRDataDriverResults(
    @SerializedName("RaceTable")
    val raceTable: DriverRaceTableDto,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class DriverRaceTableDto(
    @SerializedName("Races")
    val races: String,
    val season: String
)

data class DriverRaceDto(
    @SerializedName("Circuit")
    val circuit: CircuitDto,
    @SerializedName("Results")
    val results: List<RaceResultDto>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)

data class RaceResultDto(
    @SerializedName("Constructor")
    val constructor: ConstructorDto,
    @SerializedName("Driver")
    val driver: DriverDto,
    @SerializedName("FastestLap")
    val fastestLap: FastestLapDto,
    @SerializedName("Time")
    val time: TimeWithMillisDto,
    val grid: String,
    val laps: String,
    val number: String,
    val points: String,
    val position: String,
    val positionText: String,
    val status: String
)

data class FastestLapDto(
    @SerializedName("AverageSpeed")
    val averageSpeed: AverageSpeedDto,
    @SerializedName("Time")
    val time: TimeDto,
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
    @SerializedName("Location")
    val location: LocationDto,
    val circuitId: String,
    val circuitName: String,
    val url: String
) : Dto<Circuit> {
    override fun toDomain(): Circuit = Circuit(
        location = location.toDomain(),
        circuitId = circuitId,
        circuitName = circuitName,
        url = url,
    )

}

data class LocationDto(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
) : Dto<Location> {
    override fun toDomain(): Location = Location(
        country = country,
        lat = lat,
        locality = locality,
        long = long,
    )
}

data class TimeWithMillisDto(
    val millis: String,
    val time: String
)
