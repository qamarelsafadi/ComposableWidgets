@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.MyButton
import com.qamar.composablewidgets.ui.flippingbutton.FlipButton
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import androidx.compose.runtime.*
import com.qamar.composablewidgets.ui.button.ElasticButton
import com.qamar.composablewidgets.ui.flippingbutton.FlipFace
import com.qamar.composablewidgets.ui.theme.Blue
import com.qamar.composablewidgets.ui.theme.BorderBlue

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember {
                mutableStateOf(FlipFace.Front)
            }
            ComposableWidgetsTheme {
                Box(Modifier.fillMaxSize()
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center) {

                    FlipButton(cardFace = state,
                        back = {
                            ElasticButton(
                                onClick = {
                                    state = state.next
                                }, title = stringResource(id = R.string.back),
                                modifier = Modifier
                                    .padding(horizontal = 24.dp)
                                    .fillMaxWidth()
                                    .requiredHeight(48.dp),
                                colorBg = BorderBlue
                            )
                        },
                        front = {
                            ElasticButton(
                                onClick = {
                                    state = state.next
                                }, title = stringResource(id = R.string.front),
                                modifier = Modifier
                                    .padding(horizontal = 24.dp)
                                    .fillMaxWidth()
                                    .requiredHeight(48.dp),
                                colorBg = Blue
                            )
                        }

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