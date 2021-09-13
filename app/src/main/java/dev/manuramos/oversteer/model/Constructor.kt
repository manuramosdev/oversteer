package dev.manuramos.oversteer.model

data class Constructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String,
)

data class ConstructorStanding(
    val position: Number,
//    "positionText": "21",
    val points: Number,
    val wins: Number,
    val constructor: Constructor,
)
