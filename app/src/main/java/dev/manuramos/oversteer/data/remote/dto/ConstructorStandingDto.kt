package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.ConstructorStanding

data class ConstructorStandingDto(
    val Constructor: ConstructorDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
): Dto<ConstructorStanding> {
    override fun toDomain(): ConstructorStanding {
        return ConstructorStanding(
            points = points,
            position = position,
            wins = wins,
            constructor = Constructor.toDomain(),
        )
    }
}
