package com.qamar.composablewidgets.ui.state

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import com.qamar.composablewidgets.R

@Composable
fun StateExample() {
    //var count = 1
    var count by remember { mutableStateOf(0) }
    Button(
        onClick = {
            count++
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.white))){
        Text("Click To Update Count $count")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        StateExample()
    }
}