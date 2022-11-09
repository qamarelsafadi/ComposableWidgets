@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.ratingbar.RatingBar
import com.qamar.composablewidgets.ui.ratingbar.RatingView
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    RatingBar(
                        rating = 3.7f,
                        gab = 3.dp,
                        starDrawable = R.drawable.star,
                        starFillDrawable = R.drawable.startfill
                    )

                    RatingView(
                        Modifier.padding(top = 24.dp),
                        ratingPercentage = 0.72f
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
        RatingBar(
            rating = 3f,
            gab = 3.dp,
            starDrawable = R.drawable.star,
            starFillDrawable = R.drawable.startfill
        )
    }
}