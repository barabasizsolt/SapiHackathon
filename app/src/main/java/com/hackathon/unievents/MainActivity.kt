package com.hackathon.unievents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.hackathon.unievents.navigation.AppNavigation
import com.hackathon.unievents.navigation.BottomNavigationHolder
import com.hackathon.unievents.navigation.Route
import com.hackathon.unievents.ui.theme.UniEventsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniEventsTheme {
                val navController = rememberAnimatedNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        when (navBackStackEntry?.destination?.route) {
                            Route.SPLASH, Route.LOG_IN, Route.REGISTER -> Unit
                            else -> BottomNavigationHolder(navController = navController)
                        }
                    }
                ) {
                    AppNavigation(navController = navController)
                }
            }

        }
    }
}