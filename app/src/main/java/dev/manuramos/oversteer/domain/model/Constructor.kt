package dev.manuramos.oversteer.domain.model

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
data class Constructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String,
) : Parcelable {
    val color = Color(COLORS[constructorId] ?: 0xFFFFFFFF)
}

@Parcelize
data class ConstructorStanding(
    // todo numbers
    val position: String,
    val points: String,
    val wins: String,
    val constructor: Constructor,
): Parcelable

val COLORS: Map<String, Long> = mapOf(
    "mercedes" to 0xFF00D2BE,
    "red_bull" to 0xFF0600EF,
    "alpine" to 0xFF0090FF,
    "alphatauri" to 0xFF2B4562,
    "williams" to 0xFF005AFF,
    "aston_martin" to 0xFF006F62,
    "ferrari" to 0xFFDC0000,
    "alfa" to 0xFF900000,
    "haas" to 0xFF787878,
//    "haas" to Color(0xFFFFFFFF),
    "mclaren" to 0xFFFF8700,

    "renault" to 0xFFFFF500,
//    "renault" to Color(0xFF00ACFA),
    "force_india" to 0xFFF596C8,
    "racing_point" to 0xFFF596C8,
    "toro_rosso" to 0xFF469BFF,
    "sauber" to 0xFF006EFF
)
