package com.qamar.composablewidgets.ui.flippingbutton

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

enum class FlipFace(val angle: Float) {
    Front(0f) {
        override val next: FlipFace
            get() = Back
    },
    Back(180f) {
        override val next: FlipFace
            get() = Front
    };

    abstract val next: FlipFace
}

enum class RotationAxis {
    AxisX,
    AxisY,
}


@ExperimentalMaterialApi
@Composable
fun FlipButton(
    cardFace: FlipFace,
    modifier: Modifier = Modifier,
    axis: RotationAxis = RotationAxis.AxisY,
    back: @Composable () -> Unit = {},
    front: @Composable () -> Unit = {},
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing,
        )
    )
    Box(modifier = modifier
            .graphicsLayer {
                if (axis == RotationAxis.AxisX) {
                    rotationX = rotation.value
                } else {
                    rotationY = rotation.value
                }
                cameraDistance = 12f * density
            },
        contentAlignment = Alignment.Center
    ) {
        if (rotation.value <= 90f) {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                front()
            }
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        if (axis == RotationAxis.AxisX) {
                            rotationX = 180f
                        } else {
                            rotationY = 180f
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                back()
            }
        }
    }
}