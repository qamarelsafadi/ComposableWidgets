package com.qamar.composablewidgets.ui.aysncimage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.lottieexample.LottieAnimationSizeView


@Composable
fun AsyncImage(
    imageUrl: Any,
    modifier: Modifier
    = Modifier
        .size(90.dp)
        .padding(horizontal = 8.dp),
    contentScale: ContentScale = ContentScale.Crop
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = imageUrl,
        loading = {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                LottieAnimationSizeView(
                    raw = R.raw.imageloading,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
            }

        },
        contentDescription = "",
        contentScale = contentScale
    )
}
