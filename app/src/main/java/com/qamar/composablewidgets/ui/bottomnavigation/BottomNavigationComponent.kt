package com.qamar.composablewidgets.ui.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qamar.composablewidgets.ui.bottomnavigation.model.BottomNavItem


val bottomNavigationItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Bookmarks,
    BottomNavItem.Notification,
)


@Composable
fun BottomNavigationComponent() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        Row(
            modifier = Modifier
                .height(43.dp)
                .fillMaxWidth()
                .padding(vertical = 29.dp, horizontal = 27.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            bottomNavigationItems.forEach {
                BottomNavigationItem(
                    bottomItem = it,
                    selectedItem = bottomNavigationItems.find { item -> item.route == currentDestination?.route },
                    onClick = { bottomNavItem ->
                        NavigationActions(navController).navigate(route = bottomNavItem.route)
                    }
                )
            }
        }

    }
}


@Composable
fun BottomNavigationItem(
    bottomItem: BottomNavItem,
    selectedItem: BottomNavItem?,
    onClick: (BottomNavItem) -> Unit
) {
    val isSelected = bottomItem == selectedItem
    Row(
        modifier = Modifier
            .height(43.dp)
            .background(
                color = if (isSelected) Color.White else Color.Transparent,
                shape = RoundedCornerShape(22.dp)
            )
            .padding(horizontal = 21.dp, vertical = 12.dp)
            .clickable { onClick(bottomItem) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(bottomItem.icon), contentDescription = "",
            tint = if (isSelected) colorResource(id = R.color.selected) else colorResource(id = R.color.unselected),
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
        AnimatedVisibility(isSelected) {
            Text(
                text = bottomItem.title,
                modifier = Modifier.padding(start = 16.dp),
                maxLines = 1,
            )
        }

    }
}