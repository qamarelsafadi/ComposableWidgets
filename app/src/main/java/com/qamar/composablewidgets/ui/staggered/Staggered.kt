package com.qamar.composablewidgets.ui.staggered

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun StaggeredList(){
    LazyVerticalStaggeredGrid(
        StaggeredGridCells.Fixed(3),
    ){
        items(100){
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .aspectRatio(ratio = Random.nextDouble(0.2, 1.8).toFloat()),
                backgroundColor = Color(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
            ){}
        }
    }
}