package com.qamar.composablewidgets.ui.circleimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R

@Preview
@Composable
fun CircleImage() {
   
    
    IconButton(onClick = { /*TODO*/ },
    modifier = Modifier.clip(CircleShape)
        .background(Color.Red)) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "")
    }
}