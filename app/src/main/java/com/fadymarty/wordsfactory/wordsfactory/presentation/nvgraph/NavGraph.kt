package com.fadymarty.wordsfactory.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.fadymarty.wordsfactory.presentation.onboarding.OnBoardingScreen
import com.fadymarty.wordsfactory.presentation.onboarding.components.OnBoardingViewModel
import com.fadymarty.wordsfactory.presentation.words_navigator.WordsNavigator

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )

            }
        }

        navigation(
            route = Route.WordsNavigation.route,
            startDestination = Route.WordsNavigatorScreen.route
        ) {
            composable(route = Route.WordsNavigatorScreen.route) {
                WordsNavigator()
            }
        }
    }
}