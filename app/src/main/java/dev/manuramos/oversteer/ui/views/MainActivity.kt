package dev.manuramos.oversteer.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.manuramos.oversteer.R
import dev.manuramos.oversteer.ui.theme.OversteerTheme
import dev.manuramos.oversteer.ui.theme.Purple500
import dev.manuramos.oversteer.ui.views.calendar.CalendarScreen
import dev.manuramos.oversteer.ui.views.constructorStandings.ConstructorsScreen
import dev.manuramos.oversteer.ui.views.driverStandings.DriversScreen
import dev.manuramos.oversteer.ui.views.stats.StatsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OversteerTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar {} },
        bottomBar = { OversteerBottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Calendar.route) {
        composable(NavigationItem.Calendar.route) {
            CalendarScreen()
        }
        composable(NavigationItem.Drivers.route) {
            DriversScreen()
        }
        composable(NavigationItem.Constructors.route) {
            ConstructorsScreen()
        }
        composable(NavigationItem.Stats.route) {
            StatsScreen()
        }
    }
}

@Composable
fun OversteerBottomNavigationBar(navController: NavHostController) {
    // TODO val items = NavigationItem::class.sealedSubclasses.mapNotNull { it.objectInstance }
    val items = listOf(
        NavigationItem.Calendar,
        NavigationItem.Drivers,
        NavigationItem.Constructors,
        NavigationItem.Stats
    )
    BottomNavigation(
        backgroundColor = Purple500,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        // TODO unused?
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Calendar : NavigationItem("calendar", R.drawable.ic_calendar, "Calendar")
    object Drivers : NavigationItem("drivers", R.drawable.ic_helmet, "Drivers")
    object Constructors : NavigationItem("constructors", R.drawable.ic_tools, "Constructors")
    object Stats : NavigationItem("stats", R.drawable.ic_numbered_list, "Stats")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OversteerTheme {
        Main()
    }
}
