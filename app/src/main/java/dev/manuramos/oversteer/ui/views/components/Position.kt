package dev.manuramos.oversteer.ui.views.components

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.manuramos.oversteer.formula1Bold

@Composable
fun Position(position: String,color: Color) {
    val positionNumber = position.toInt()
    val ordinal = positionNumber.th
    Text(
        fontSize = 22.sp,
        fontFamily = formula1Bold,
        modifier = Modifier.width(45.dp),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(color = color),

            ) {
                append(positionNumber.toString())
            }
            withStyle(
                style = SpanStyle(
                    baselineShift = BaselineShift.Superscript,
                    fontSize = 10.sp, color = color
                )
            ) {
                append(ordinal)
            }
        }
    )
}

val Int.th: String
    get() = if (this % 100 in 11..13) "th" else when (this % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
