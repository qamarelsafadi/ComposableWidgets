package com.qamar.composablewidgets.ui.statehoisting

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    Counter(
        count = count,
        onCounterChange = {
            count++
        })
}

@Composable
fun Counter(count: Int, onCounterChange: () -> Unit) {
    Button(onClick = onCounterChange) {
        Text("Count: $count")
    }
}