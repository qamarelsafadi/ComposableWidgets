package com.qamar.composablewidgets.ui.codearrangment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.carouselview.CarouselView
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme

@Composable
fun CodeArrangement() {
    Surface(color = Color.Black) {
        Card(
            modifier = Modifier
                .aspectRatio(1f)
        ) {
            Text(
                "Lets see what",
                color = Color.Black,
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color.Blue)
                    .padding(16.dp)

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        CodeArrangement()
    }
}