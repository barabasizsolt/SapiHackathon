package com.hackathon.unievents.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.hackathon.unievents.ui.screen.events.EventScreen
import com.hackathon.unievents.ui.screen.events.EventViewModel
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailScreen
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailViewModel
import com.hackathon.unievents.ui.screen.auth.LoginScreen
import com.hackathon.unievents.ui.screen.auth.LoginScreenViewModel
import com.hackathon.unievents.ui.screen.auth.RegisterScreen
import com.hackathon.unievents.ui.screen.auth.RegisterScreenViewModel
import com.hackathon.unievents.ui.screen.profile.ProfileScreen
import com.hackathon.unievents.ui.screen.profile.ProfileViewModel
import com.hackathon.unievents.ui.screen.teams.TeamViewModel
import com.hackathon.unievents.ui.screen.teams.TeamsScreen
import com.hackathon.unievents.ui.screen.teamsDetail.TeamDetailViewModel
import com.hackathon.unievents.ui.screen.teamsDetail.TeamsDetailScreen
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    AnimatedNavHost(
        navController,
        startDestination = Route.SPLASH,
    ) {

        composable(route = Route.SPLASH) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = MaterialTheme.colors.onSurface)
                LaunchedEffect(key1 = Unit, block = {
                    delay(timeMillis = 1500)
                    navController.navigate(route = Route.LOG_IN) { launchSingleTop = true }
                } )
            }
        }

        composable(route = Route.LOG_IN) {
            LoginScreen(viewModel = getViewModel<LoginScreenViewModel>().apply {
                when (event?.consume()) {
                    is LoginScreenViewModel.Action.OnLoginSuccess -> navController.navigate(route = Route.EVENTS) {
                        launchSingleTop = true
                        popUpTo(Route.SPLASH) {
                            inclusive = true
                        }
                    }
                    is LoginScreenViewModel.Action.OnForgotPasswordClicked -> navController.navigate(route = Route.REGISTER) { launchSingleTop = true }
                    is LoginScreenViewModel.Action.OnRegisterClicked -> navController.navigate(route = Route.REGISTER) { launchSingleTop = true }
                }
            })
        }

        composable(route = Route.REGISTER) {
            RegisterScreen(viewModel = getViewModel<RegisterScreenViewModel>().apply {
                when (event?.consume()) {
                    is RegisterScreenViewModel.Action.NavigateUp -> navController.navigateUp()
                    is RegisterScreenViewModel.Action.OnRegisterSuccess -> navController.navigate(route = Route.EVENTS) { launchSingleTop = true }
                }
            })
        }

        composable(route = Route.EVENTS) {
            EventScreen(viewModel = getViewModel<EventViewModel>().apply {
                when (event?.consume()) {
                    is EventViewModel.Action.NavigateToEventDetailScreen -> navController.navigate(route = Route.EVENTS_DETAIL) { launchSingleTop = true }
                    is EventViewModel.Action.NavigateToTeamDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL) { launchSingleTop = true }
                }
            })
        }

        composable(route = Route.EVENTS_DETAIL) {
            EventDetailScreen(viewModel = getViewModel<EventDetailViewModel>().apply {
                when (event?.consume()) {
                    is EventDetailViewModel.Action.NavigateUp -> navController.navigateUp()
                    is EventDetailViewModel.Action.NavigateToTeamDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL) { launchSingleTop = true }
                }
            })
        }

        composable(route = Route.TEAMS) {
            TeamsScreen(viewModel = getViewModel<TeamViewModel>().apply {
                when (event?.consume()) {
                    TeamViewModel.Action.NavigateUp -> navController.navigateUp()
                    TeamViewModel.Action.NavigateToDetailScreen -> navController.navigate(route = Route.TEAMS_DETAIL) { launchSingleTop = true }
                }
            })
        }

        composable(route = Route.TEAMS_DETAIL) {
            TeamsDetailScreen(viewModel = getViewModel<TeamDetailViewModel>().apply {
                when (event?.consume()) {
                    TeamDetailViewModel.Action.NavigateUp -> navController.navigateUp()
                }
            })
        }

        composable(route = Route.PROFILE) {
            ProfileScreen(viewModel = getViewModel<ProfileViewModel>().apply {
                when (event?.consume()) {
                    ProfileViewModel.Action.LogOut -> navController.navigate(route = Route.LOG_IN) {
                        launchSingleTop = true
                        popUpTo(Route.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            })
        }
    }
}