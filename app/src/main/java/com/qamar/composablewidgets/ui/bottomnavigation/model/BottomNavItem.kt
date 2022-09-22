package com.qamar.composablewidgets.ui.bottomnavigation.model

import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.bottomnavigation.Destinations.BOOKMARKS
import com.qamar.composablewidgets.ui.bottomnavigation.Destinations.HOME
import com.qamar.composablewidgets.ui.bottomnavigation.Destinations.NOTIFICATION

sealed class BottomNavItem(var title: String, var icon: Int, val route: String) {
    object Home : BottomNavItem("Home", R.drawable.home_icon, HOME)
    object Bookmarks : BottomNavItem("Bookmarks", R.drawable.home_icon, BOOKMARKS)
    object Notification : BottomNavItem("Notification", R.drawable.home_icon, NOTIFICATION)
}