package com.fadymarty.wordsfactory.presentation.nvgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route("onBoardingScreen")
    object DictionaryScreen : Route("dictionaryScreen")
    object TrainingScreen : Route("trainingScreen")
    object VideoScreen : Route("videoScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object WordsNavigation : Route(route = "wfNavigation")
    object WordsNavigatorScreen : Route(route = "wfNavigator")
}