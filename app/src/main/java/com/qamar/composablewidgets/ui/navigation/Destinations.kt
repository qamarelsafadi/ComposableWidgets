package com.qamar.composablewidgets.ui.navigation

import androidx.navigation.NavHostController

object Destinations {
    const val SCREEN_1 = "screen1"
    const val SCREEN_2 = "screen2/"
    const val SCREEN_2_WITH_ARGUMENT = "screen2/{previousName}"
}

class NavigationActions(private val navController: NavHostController) {
    fun navigateToScreen2(previousName: String){
        navController.navigate("${Destinations.SCREEN_2}${previousName}")
    }
    fun navigateBack(){
        navController.navigateUp()
    }
}