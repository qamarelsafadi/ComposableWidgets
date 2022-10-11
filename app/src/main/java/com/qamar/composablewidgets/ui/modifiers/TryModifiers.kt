package com.qamar.composablewidgets.ui.modifiers

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val colorsList = listOf<Color>(Color.Red, Color.Black, Color.Blue, Color.Yellow)

val boxModifier = Modifier
    .fillMaxWidth()
    .requiredHeight(150.dp)
    .background(
        colorsList
            .shuffled()
            .first()
    )


val padding30 = Modifier.padding(30.dp)

@Composable
fun TryModifiers() {
    var count by remember {
        mutableStateOf(0)
    }
    Surface(color = Color.White) {
        // No allocation, as we're just reusing the same instance
        Box(modifier =  padding30.then(boxModifier).clickable {
            count++
            Log.e("QMR", "Hey Click$count")
        })
    }
}