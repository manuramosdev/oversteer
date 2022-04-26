package dev.manuramos.oversteer.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.ConstructorStanding

data class ConstructorStandingDto(
    @SerializedName("Constructor")
    val constructor: ConstructorDto,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
) : Dto<ConstructorStanding> {
    override fun toDomain(): ConstructorStanding = ConstructorStanding(
        points = points,
        position = position,
        wins = wins,
        constructor = constructor.toDomain(),
    )
}
