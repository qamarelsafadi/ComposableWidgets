package com.qamar.composablewidgets.ui.blurimage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R

@Composable
fun BlurImageComponent(){
    Box() {
        Image(
            painter = painterResource(id = R.drawable.main_image), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .blur(11.dp),
            contentScale = ContentScale.Crop
        )
        Card(
            elevation = 18.dp,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .width(255.5.dp)
                .height(432.dp)
                .background(color = Color.Transparent)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_image), contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
    }

}