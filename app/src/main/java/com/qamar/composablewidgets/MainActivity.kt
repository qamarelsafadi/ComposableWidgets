@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.MyButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                var otpValue by remember {
                    mutableStateOf("")
                }
                MyButton(
                    text = "My Custom Button",
                    backgroundColor = Color.Blue,
                    roundedRadius = 8.dp,
                    leadingIcon = {
                        Icon(Icons.Filled.Star, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(Icons.Filled.Star, contentDescription = null)
                    },
                    onClick = {
                        // Perform action when button is clicked
                    }
                )
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