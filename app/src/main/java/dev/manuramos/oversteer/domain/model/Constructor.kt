package dev.manuramos.oversteer.domain.model

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

val COLORS = mapOf(
    "mercedes" to 0xFF00D2BE,
    "red_bull" to 0xFF0600EF,
    "alpine" to 0xFF0090FF,
    "alphatauri" to 0xFF2B4562,
    "williams" to 0xFF005AFF,
    "aston_martin" to 0xFF006F62,
    "ferrari" to 0xFFDC0000,
    "alfa" to 0xFF900000,
    "haas" to 0xFFFFFFFF,
    "mclaren" to 0xFFFF8700,

    "renault" to 0xFF00ACFA,
)
