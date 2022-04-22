package dev.manuramos.oversteer.domain.model

import androidx.compose.ui.graphics.Color

data class Constructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String,
) {
    val color: Color = COLORS[constructorId] ?: Color(0xFFFFFFFF)
}

data class ConstructorStanding(
    // todo numbers
    val position: String,
    val points: String,
    val wins: String,
    val constructor: Constructor,
)

val COLORS: Map<String, Color> = mapOf(
    "mercedes" to Color(0xFF00D2BE),
    "red_bull" to Color(0xFF0600EF),
    "alpine" to Color(0xFF0090FF),
    "alphatauri" to Color(0xFF2B4562),
    "williams" to Color(0xFF005AFF),
    "aston_martin" to Color(0xFF006F62),
    "ferrari" to Color(0xFFDC0000),
    "alfa" to Color(0xFF900000),
    "haas" to Color(0xFF787878),
//    "haas" to Color(0xFFFFFFFF),
    "mclaren" to Color(0xFFFF8700),

    "renault" to Color(0xFFFFF500),
//    "renault" to Color(0xFF00ACFA),
    "force_india" to Color(0xFFF596C8),
    "racing_point" to Color(0xFFF596C8),
    "toro_rosso" to Color(0xFF469BFF),
    "sauber" to Color(0xFF006EFF)
)
