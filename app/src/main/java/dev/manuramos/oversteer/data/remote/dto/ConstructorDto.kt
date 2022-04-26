package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.data.Dto
import dev.manuramos.oversteer.domain.model.Constructor

data class ConstructorDto(
    val constructorId: String,
    val name: String,
    val nationality: String,
    val url: String
) : Dto<Constructor> {
    override val data = Constructor(
        constructorId = constructorId,
        name = name,
        nationality = nationality,
        url = url,
    )
}
