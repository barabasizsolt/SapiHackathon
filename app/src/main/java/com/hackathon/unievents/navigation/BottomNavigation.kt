package com.hackathon.unievents.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hackathon.unievents.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Events : BottomNavItem(
        title = "Events",
        icon = R.drawable.ic_nav_event,
        screen_route = Route.EVENTS
    )
    object Teams: BottomNavItem(
        title = "Teams",
        icon = R.drawable.ic_nav_team,
        screen_route = Route.TEAMS
    )
    object Profile: BottomNavItem(
        title = "Profile",
        icon = R.drawable.ic_nav_profile,
        screen_route = Route.PROFILE
    )
}

@Composable
fun BottomNavigationHolder(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Events,
        BottomNavItem.Teams,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.Black,
        elevation = 4.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val selectedColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 9.sp) },
                selectedContentColor = selectedColor,
                unselectedContentColor = selectedColor.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
