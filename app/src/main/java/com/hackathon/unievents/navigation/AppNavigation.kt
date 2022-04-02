package com.hackathon.unievents.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.hackathon.unievents.ui.screen.events.EventScreen
import com.hackathon.unievents.ui.screen.events.EventViewModel
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailScreen
import com.hackathon.unievents.ui.screen.profile.ProfileScreen
import com.hackathon.unievents.ui.screen.teams.TeamsScreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    AnimatedNavHost(
        navController,
        startDestination = Route.EVENTS,
    ) {

        composable(route = Route.EVENTS) {
            EventScreen(viewModel = getViewModel<EventViewModel>().apply {
                when (event?.consume()) {
                    is EventViewModel.Action.NavigateUp -> navController.navigateUp()
                    is EventViewModel.Action.NavigateToDetailScreen -> navController.navigate(route = Route.EVENTS_DETAIL)
                }
            })
        }

        composable(route = Route.EVENTS_DETAIL) {
            EventDetailScreen()
        }

        composable(route = Route.TEAMS) {
            TeamsScreen()
        }

        composable(route = Route.PROFILE) {
            ProfileScreen()
        }
    }
}