package com.qamar.composablewidgets.ui.sideeffect

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*


@Composable
fun TrySideEffect() {
    var backgroundColor by remember { mutableStateOf(Color.Blue) }
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .size(150.dp)
    )

    SideEffect {
        Thread.sleep(1000)
        backgroundColor = Color.Black
    }
}

val colorsList = listOf<Color>(Color.Red, Color.Black, Color.Blue, Color.Yellow)

@Composable
fun TryLaunchedEffect() {
    var backgroundColor by remember { mutableStateOf(colorsList) }
    Log.e("QMR", "Recomposition")
   LaunchedEffect(key1 = Unit){
       getApi()
   }
    Box(modifier = Modifier
        .clickable {
            backgroundColor = colorsList.shuffled()
        }
        .background(backgroundColor.last())
        .size(150.dp))

}

fun getApi(){
    Log.e("QMR", "get api call")
}
