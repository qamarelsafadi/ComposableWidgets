package com.qamar.composablewidgets.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.SCREEN_1
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.SCREEN_1) {
            Screen1(){
                NavigationActions(navController).navigateToScreen2(it)
            }
        }
        composable(Destinations.SCREEN_2_WITH_ARGUMENT){
            val previousName = it.arguments?.getString("previousName")
            Screen2(previousName){
                NavigationActions(navController).navigateBack()
            }
        }
    }
}