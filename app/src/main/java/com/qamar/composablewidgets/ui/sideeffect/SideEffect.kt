package com.qamar.composablewidgets.ui.sideeffect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TrySideEffect() {
    var backgroundColor by remember { mutableStateOf(Color.Blue) }
    Box(modifier = Modifier
        .background(backgroundColor)
        .size(150.dp))

    SideEffect {
        Thread.sleep(1000)
        backgroundColor = Color.Black
    }
}