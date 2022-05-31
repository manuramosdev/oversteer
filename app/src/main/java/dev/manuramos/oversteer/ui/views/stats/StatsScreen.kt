package dev.manuramos.oversteer.ui.views.stats

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.manuramos.oversteer.ui.views.OversteerBottomNavigationBar

@Destination
@Composable
fun StatsScreen(navigator: DestinationsNavigator) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Row() {
                    Text(
                        text = "SportsDataApp", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )


                }
            }
        },
        bottomBar = { OversteerBottomNavigationBar(navigator) }
    ) {
        Text(text = "Stats")
    }
}
