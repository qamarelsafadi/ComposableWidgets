package com.qamar.composablewidgets.ui.animatedbackgroundcolor

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AnimatedBackgroundColor() {
    var color by remember {
        mutableStateOf(Color.Black)
    }

    val animatedColor: Color by animateColorAsState(
        targetValue = color,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 20,
            easing = LinearOutSlowInEasing
        )
    )

    Box(modifier = Modifier
        .background(
            color = animatedColor,
            RoundedCornerShape(15.dp)
        )
        .size(100.dp)
        .clickable {
            color = if (color == Color.Black) Color.Red else Color.Black
        }
    )
}