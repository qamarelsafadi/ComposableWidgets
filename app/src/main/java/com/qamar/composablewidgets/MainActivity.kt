@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.qamar.composablewidgets.figmacard.FigmaCard
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                FigmaCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        FigmaCard()
    }
}