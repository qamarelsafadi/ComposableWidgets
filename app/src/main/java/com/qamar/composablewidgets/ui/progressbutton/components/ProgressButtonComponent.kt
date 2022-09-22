package com.qamar.composablewidgets.ui.progressbutton.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
fun ProgressButtonComponents(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    color: Int,
    progressColor: Int,
    content: @Composable () -> Unit,
) {
    val contentAlpha by animateFloatAsState(targetValue = if (loading) 0f else 1f)
    val loadingAlpha by animateFloatAsState(targetValue = if (loading) 1f else 0f)
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(color)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(size = 16.dp)
                    .graphicsLayer { alpha = loadingAlpha },
                color = colorResource(progressColor),
                strokeWidth = 2.dp,
            )
            Box(
                modifier = Modifier.graphicsLayer { alpha = contentAlpha }
            ) {
                content()
            }
        }
    }
}
