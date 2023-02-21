package com.qamar.composablewidgets.ui.circleimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R

@Preview
@Composable
fun CircleImage() {
    Image(
        painter = painterResource(id = R.drawable.main_image),
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(100.dp)
            .clip(CircleShape)
            .blur(radius = 10.dp)

    )
}