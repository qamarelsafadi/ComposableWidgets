package com.qamar.composablewidgets.ui.topbar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopBar(){

    Scaffold(topBar = {

        LargeTopAppBar(title = {
            Text(text = "Title")
        },
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior())
    }) {

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(it)){
            items(100){
                Card(colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .fillMaxSize()
                    .height(100.dp)) {
                    
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}