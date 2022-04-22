package dev.manuramos.oversteer.ui.views.components

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.manuramos.oversteer.formula1Bold


@Composable
fun Points(points: String) {
    Text(
        text = points,
        fontSize = 22.sp,
        fontFamily = formula1Bold,
        modifier = Modifier.width(70.dp)
    )
}
