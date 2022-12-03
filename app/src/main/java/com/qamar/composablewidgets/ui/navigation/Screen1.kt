package com.qamar.composablewidgets.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Screen1(onClick: (String) -> Unit){
    Scaffold {
        Box(modifier = Modifier.padding(it).fillMaxSize()){
            Button(onClick = {
                onClick("Screen 1")
            },
            modifier = Modifier.align(Alignment.Center)) {
                Text(text = "Click here to go to Screen 2")
            }
        }
    }
}