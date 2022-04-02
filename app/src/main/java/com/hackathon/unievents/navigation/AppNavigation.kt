package com.hackathon.unievents.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.hackathon.unievents.ui.screen.events.EventScreen
import com.hackathon.unievents.ui.screen.events.EventViewModel
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailScreen
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailViewModel
import com.hackathon.unievents.ui.screen.profile.ProfileScreen
import com.hackathon.unievents.ui.screen.teams.TeamViewModel
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
                    is EventViewModel.Action.NavigateToEventDetailScreen -> navController.navigate(route = Route.EVENTS_DETAIL)
                    is EventViewModel.Action.NavigateToTeamDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL)
                }
            })
        }

        composable(route = Route.EVENTS_DETAIL) {
            EventDetailScreen(viewModel = getViewModel<EventDetailViewModel>().apply {
                when (event?.consume()) {
                    is EventDetailViewModel.Action.NavigateUp -> navController.navigateUp()
                    is EventDetailViewModel.Action.NavigateToTeamDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL)
                }
            })
        }

        composable(route = Route.TEAMS) {
            TeamsScreen(viewModel = getViewModel<TeamViewModel>().apply {
                when (event?.consume()) {
                    TeamViewModel.Action.NavigateUp -> navController.navigateUp()
                    TeamViewModel.Action.NavigateToDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL)
                }
            })
        }

        composable(route = Route.TEAMS_DETAIL) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Green)) {}
        }

        composable(route = Route.PROFILE) {
            ProfileScreen()
        }
    }
}