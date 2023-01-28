@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.qamar.composablewidgets.figmacard.FigmaCard
import com.qamar.composablewidgets.ui.otp.OtpView
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.MyButton
import com.qamar.composablewidgets.ui.aysncimage.AsyncImage
import com.qamar.composablewidgets.ui.theme.Bg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                Box(Modifier.fillMaxSize()
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center) {
                    AsyncImage(
                        imageUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/5bb2e531a22c7de0.png",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(64.dp)
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        MyButton(
            text = "My Custom Button",
            backgroundColor = Color.Blue,
            roundedRadius = 8.dp,
            leadingIcon = {
                Icon(Icons.Filled.Star, contentDescription = null)
            },
            onClick = {
                // Perform action when button is clicked
            }
        )
    }
}