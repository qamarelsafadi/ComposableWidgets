package com.qamar.composablewidgets.utils

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.qamar.composablewidgets.ui.navigation.Destinations

fun NavController.showingBack(currentRoute:NavBackStackEntry?): Boolean {
    val showBackButton = when (currentRoute?.destination?.route) {
        Destinations.SCREEN_1 -> false
        else -> true
    }
    return showBackButton
}
