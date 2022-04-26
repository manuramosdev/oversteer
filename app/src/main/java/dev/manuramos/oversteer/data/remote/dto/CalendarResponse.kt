package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.data.data
import dev.manuramos.oversteer.domain.model.Race
import java.util.*

data class CalendarResponse(
    @SerializedName("MRData")
    val mRData: MRDataCalendar
): Dto<List<Race>> {
    override val data: List<Race> = mRData.raceTable.races.data
}

data class MRDataCalendar(
    @SerializedName("RaceTable")
    val raceTable: RaceTableDto,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)

data class RaceTableDto(
    @SerializedName("Races")
    val races: List<RaceDto>,
    val season: String
)

data class RaceDto(
    @SerializedName("Circuit")
    val circuit: CircuitDto,
    @SerializedName("FirstPractice")
    val firstPractice: SessionTimeDto,
    @SerializedName("Qualifying")
    val qualifying: SessionTimeDto,
    @SerializedName("SecondPractice")
    val secondPractice: SessionTimeDto,
    @SerializedName("Sprint")
    val sprint: SessionTimeDto?,
    @SerializedName("ThirdPractice")
    val thirdPractice: SessionTimeDto?,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
) : Dto<Race> {
    override val data = Race(
            circuit = circuit.data,
            firstPractice = firstPractice.data,
            qualifying = qualifying.data,
            secondPractice = secondPractice.data,
            sprint = sprint?.data,
            thirdPractice = thirdPractice?.data,
            race = Date(),
            raceName = raceName,
            round = round,
            season = season,
            url = url,
        )
}

data class SessionTimeDto(
    val date: String,
    val time: String
) : Dto<Date> {
    // todo
    override val data = Date()
}
