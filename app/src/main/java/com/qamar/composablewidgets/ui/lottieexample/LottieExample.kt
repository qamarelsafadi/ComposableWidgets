package com.qamar.composablewidgets.ui.lottieexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.*
import com.qamar.composablewidgets.R

@Composable
fun LottieExample() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.androiditem))
    LottieAnimation(
        composition,
        iterations = LottieConstants.IterateForever
    )
}

@Composable
fun LottieAnimationSizeView(modifier: Modifier = Modifier, raw: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(raw))
    LottieAnimation(
        composition,
        modifier = modifier,
        iterations = LottieConstants.IterateForever,
        contentScale = ContentScale.None
    )
}
