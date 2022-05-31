package dev.manuramos.oversteer.ui.views.driverStandings

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.manuramos.oversteer.domain.model.DriverStanding
import dev.manuramos.oversteer.ui.views.OversteerBottomNavigationBar
import dev.manuramos.oversteer.ui.views.components.Position
import dev.manuramos.oversteer.ui.views.destinations.DriverDetailScreenDestination

@Destination
@Composable
fun DriverDetailScreen(driverStanding: DriverStanding, navigator: DestinationsNavigator) {
    val driver = driverStanding.driver
    val teamColor = driverStanding.constructors.first().color
    Scaffold(
        topBar = { TopAppBar {} },
        bottomBar = { OversteerBottomNavigationBar(navigator) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        )
        {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp,
                border = BorderStroke(3.dp, Color.LightGray)
            ) {
                Column(Modifier.background(
                    teamColor
                )) {
                    Row() {
                        DriverCardText(driver.fullName, 25)
                    }
                    Row(Modifier.padding(10.dp)) {
                        Column(Modifier.fillMaxWidth(0.333f)) {
                            DriverCardText("Position", 22)
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Position(driverStanding.position, Color.White)
                            }
                        }
                        Column(Modifier.fillMaxWidth(0.5f)) {
                            DriverCardText("Points", 22)
                            DriverCardText(driverStanding.points, 22)
                        }
                        Column() {
                            DriverCardText("Wins", 22)
                            DriverCardText(driverStanding.wins.toString(), 22)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun DriverCardText(content: String, fontSize: Int) {
    Text(
        text = content, Modifier.fillMaxWidth(), color = Color.White,
        fontSize = fontSize.sp, textAlign = TextAlign.Center
    )
}


