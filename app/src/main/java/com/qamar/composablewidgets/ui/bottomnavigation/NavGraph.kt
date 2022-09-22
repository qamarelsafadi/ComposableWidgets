package com.qamar.composablewidgets.ui.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qamar.composablewidgets.ui.bottomnavigation.destinations.BookmarksScreen
import com.qamar.composablewidgets.ui.bottomnavigation.destinations.HomeScreen
import com.qamar.composablewidgets.ui.bottomnavigation.destinations.NotificationScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Destinations.HOME) {
            HomeScreen()
        }
        composable(Destinations.BOOKMARKS) {
            BookmarksScreen()
        }
        composable(Destinations.NOTIFICATION) {
            NotificationScreen()
        }
    }
}