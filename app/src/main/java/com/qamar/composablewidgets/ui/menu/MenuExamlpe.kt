package com.qamar.composablewidgets.ui.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuExample(){
    Scaffold(
        topBar = {  TopAppBar(
            title = { Text("Title") },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Favorite,"Favorite")
                }
                IconButton(onClick = { /*TODO*/}) {
                    Icon(Icons.Default.MoreVert,"More")
                }
            }
        )},
        backgroundColor = Color.Gray,
        contentColor = Color.White
    ) { it ->
        Box(modifier = Modifier
            .size(100.dp)
            .padding(it))
    }

}