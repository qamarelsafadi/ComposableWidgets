package com.qamar.composablewidgets.ui.recyclerview.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListComponent(myList: List<String>) {
    LazyColumn {
        items(myList) { item ->
            Text(
                text = "Hello $item!", Modifier.padding(
                    24.dp
                )
            )
        }
    }
}