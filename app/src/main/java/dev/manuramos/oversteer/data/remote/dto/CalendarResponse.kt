package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.Race
import java.util.*

data class CalendarResponse(
    val MRData: MRDataCalendar
)

data class MRDataCalendar(
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
    val season: String
)

data class RaceDto(
    val Circuit: CircuitDto,
    val FirstPractice: SessionTimeDto,
    val Qualifying: SessionTimeDto,
    val SecondPractice: SessionTimeDto,
    val Sprint: SessionTimeDto?,
    val ThirdPractice: SessionTimeDto?,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
) : Dto<Race> {
    override fun toDomain(): Race = Race(
        circuit = Circuit.toDomain(),
        firstPractice = FirstPractice.toDomain(),
        qualifying = Qualifying.toDomain(),
        secondPractice = SecondPractice.toDomain(),
        sprint = Sprint?.toDomain(),
        thirdPractice = ThirdPractice?.toDomain(),
        // todo
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
    override fun toDomain(): Date = Date()
}
