package com.qamar.composablewidgets.ui.stickyheaderecyclerview.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ItemList(contact: String) {
    Row() {
        Text(
            contact,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            color = Color.White,

            )
    }
}

@Composable
fun HeaderItem(initial: Char) {
    Text(
        initial.toString(),
        modifier = Modifier
            .background(Color.Gray)
            .padding(5.dp)
            .fillMaxWidth(),
        color = Color.White,

        )
}
