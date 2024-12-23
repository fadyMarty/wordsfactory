package com.fadymarty.wordsfactory.presentation.words_navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.presentation.dictionary.DictionaryScreen
import com.fadymarty.wordsfactory.presentation.dictionary.DictionaryViewModel
import com.fadymarty.wordsfactory.presentation.nvgraph.Route
import com.fadymarty.wordsfactory.presentation.videos.VideosScreen
import com.fadymarty.wordsfactory.presentation.words_navigator.components.BottomNavigationItem
import com.fadymarty.wordsfactory.presentation.words_navigator.components.WordsBottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordsNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_dictionary, text = "Dictionary"),
            BottomNavigationItem(icon = R.drawable.ic_training, text = "Training"),
            BottomNavigationItem(icon = R.drawable.ic_video, text = "Video")
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = remember(backstackState) {
        when (backstackState?.destination?.route) {
            Route.DictionaryScreen.route -> 0
            Route.TrainingScreen.route -> 1
            Route.VideoScreen.route -> 2
            else -> 0
        }
    }

    val isBottomBarVisible = remember(backstackState) {
        backstackState?.destination?.route == Route.DictionaryScreen.route ||
                backstackState?.destination?.route == Route.TrainingScreen.route ||
                backstackState?.destination?.route == Route.VideoScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                WordsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap(
                                navController = navController,
                                route = Route.DictionaryScreen.route
                            )

                            1 -> navigateToTap(
                                navController = navController,
                                route = Route.TrainingScreen.route
                            )

                            2 -> navigateToTap(
                                navController = navController,
                                route = Route.VideoScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Route.DictionaryScreen.route,
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
        ) {
            composable(route = Route.DictionaryScreen.route) {
                val viewModel: DictionaryViewModel = hiltViewModel()
                DictionaryScreen(viewModel, viewModel.wordState.value)
            }

            composable(route = Route.TrainingScreen.route) {

            }

            composable(route = Route.VideoScreen.route) {
                VideosScreen()
            }
        }
    }
}

private fun navigateToTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { dictionaryScreen ->
            popUpTo(dictionaryScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}