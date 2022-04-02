package com.hackathon.unievents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.hackathon.unievents.navigation.AppNavigation
import com.hackathon.unievents.navigation.BottomNavigationHolder

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            UniEventsTheme {
//                AppNavigation()
//            }
            //
            val navController = rememberAnimatedNavController()
            Scaffold(
                bottomBar = { BottomNavigationHolder(navController = navController) }
            ) {
                AppNavigation(navController = navController)
            }
        }
    }
}