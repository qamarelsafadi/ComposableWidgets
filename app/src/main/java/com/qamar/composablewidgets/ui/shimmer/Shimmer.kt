package com.qamar.composablewidgets.ui.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ShimmerItem(color: Color) {
    val gradient = listOf(
        color.copy(alpha = 0.9f),
        color.copy(alpha = 0.4f),
        color.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = FastOutLinearInEasing
            )
        )
    )
    val brush = linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )
    // Your content
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .height(91.dp)
            .padding(bottom = 6.dp)
            .background(brush)
    ) {
     /*   Row(
            modifier = Modifier
                .wrapContentSize(Alignment.CenterStart)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
      */
    }
}