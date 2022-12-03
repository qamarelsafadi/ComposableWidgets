@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.calender.Calendar
import com.qamar.composablewidgets.ui.carouselview.CarouselView
import com.qamar.composablewidgets.ui.navigation.NavigationHost
import com.qamar.composablewidgets.ui.navigation.Screen1
import com.qamar.composablewidgets.ui.progressbutton.ProgressButton
import com.qamar.composablewidgets.ui.ratingbar.RatingBar
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                NavigationHost()
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