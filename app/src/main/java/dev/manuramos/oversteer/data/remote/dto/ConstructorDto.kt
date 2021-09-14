package dev.manuramos.oversteer.data.remote.dto

import dev.manuramos.oversteer.domain.model.COLORS
import dev.manuramos.oversteer.domain.model.Constructor

data class ConstructorDto(
    val constructorId: String,
    val name: String,
    val nationality: String,
    val url: String
)

fun ConstructorDto.toConstructor(): Constructor = Constructor(
    constructorId = constructorId,
    name = name,
    nationality = nationality,
    url = url,
    color = COLORS[constructorId] ?: 0xFFFFFFFF
)