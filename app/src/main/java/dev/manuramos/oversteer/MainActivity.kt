package dev.manuramos.oversteer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.manuramos.oversteer.ui.theme.OversteerTheme
import dev.manuramos.oversteer.ui.theme.Purple500


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OversteerTheme() {
                Main()
            }
        }
    }

}

@Composable
fun Main() {
    Scaffold (
        topBar = { TopAppBar {} },
        bottomBar = { MyBNB() }
    ){

    }
}

@Composable
fun MyBNB() {
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
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
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
