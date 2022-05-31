package dev.manuramos.oversteer.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint
import dev.manuramos.oversteer.R
import dev.manuramos.oversteer.ui.theme.OversteerTheme
import dev.manuramos.oversteer.ui.theme.Purple500
import dev.manuramos.oversteer.ui.views.NavGraphs
import dev.manuramos.oversteer.ui.views.destinations.CalendarScreenDestination
import dev.manuramos.oversteer.ui.views.destinations.ConstructorsScreenDestination
import dev.manuramos.oversteer.ui.views.destinations.DriversScreenDestination
import dev.manuramos.oversteer.ui.views.destinations.StatsScreenDestination

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OversteerTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}




@Composable
fun OversteerBottomNavigationBar(navigator: DestinationsNavigator,  modifier:
                                  Modifier =Modifier.fillMaxHeight(0.1f)) {

    BottomNavigation(
        backgroundColor = Purple500,
        contentColor = Color.White
    ) {
        /*   val navBackStackEntry by navContuserler.currentBackStackEntryAsState()
           // TODO unused?
           val currentRoute = navBackStackEntry?.destination?.route
        */
        BottomNavigationItem(
            icon = { Icon(painterResource(id = NavigationItem.Calendar.icon),
                contentDescription = NavigationItem.Calendar.title) },
            label = { Text(text = NavigationItem.Calendar.title) },
            selectedContentColor = Color.White,
            alwaysShowLabel = true,
            selected = false,
            onClick = {
                navigator.navigate(CalendarScreenDestination())
            }
        )


        BottomNavigationItem(
            icon = { Icon(painterResource(id = NavigationItem.Drivers.icon),
                contentDescription = NavigationItem.Drivers.title) },
            label = { Text(text = NavigationItem.Drivers.title) },
            selectedContentColor = Color.White,
            alwaysShowLabel = true,
            selected = false,
            onClick = {
                navigator.navigate(DriversScreenDestination())
            }
        )

        BottomNavigationItem(
            icon = { Icon(painterResource(id = NavigationItem.Constructors.icon),
                contentDescription = NavigationItem.Constructors.title) },
            label = { Text(text = NavigationItem.Constructors.title) },
            selectedContentColor = Color.White,
            alwaysShowLabel = true,
            selected = false,
            onClick = {
                navigator.navigate(ConstructorsScreenDestination())
            }
        )
        BottomNavigationItem(
            icon = { Icon(painterResource(id = NavigationItem.Stats.icon),
                contentDescription = NavigationItem.Stats.title) },
            label = { Text(text = NavigationItem.Stats.title) },
            selectedContentColor = Color.White,
            alwaysShowLabel = true,
            selected = false,
            onClick = {
                navigator.navigate(StatsScreenDestination())
            }
        )


    }
}

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Calendar : NavigationItem("calendar", R.drawable.ic_calendar, "Calendar")
    object Drivers : NavigationItem("drivers", R.drawable.ic_helmet, "Drivers")
    object Constructors : NavigationItem("constructors", R.drawable.ic_tools, "Constructors")
    object Stats : NavigationItem("stats", R.drawable.ic_numbered_list, "Stats")
}
