package com.qamar.composablewidgets.ui.gradient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Gradient() {
    val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Button(
        modifier = Modifier.height(46.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        onClick = {

        }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Button")
        }
    }
}