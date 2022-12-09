@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.qamar.composablewidgets.ui.navigation.NavigationHost
import com.qamar.composablewidgets.ui.progressbutton.ProgressButton
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.qamar.composablewidgets.ui.navigation.Destinations
import com.qamar.composablewidgets.utils.showingBack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val currentRoute = navController
                .currentBackStackEntryFlow
                .collectAsState(initial = navController.currentBackStackEntry)
            ComposableWidgetsTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = "") },
                        navigationIcon = {
                            AnimatedVisibility(visible = navController.showingBack(currentRoute.value)) {
                                IconButton(onClick = {
                                    navController.navigateUp()
                                }) {
                                    Icon(Icons.Rounded.ArrowBack, "",
                                        tint = Color.White)
                                }
                            }
                        }
                    )
                }) {it ->
                    NavigationHost(navController = navController )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        ProgressButton()
    }
}