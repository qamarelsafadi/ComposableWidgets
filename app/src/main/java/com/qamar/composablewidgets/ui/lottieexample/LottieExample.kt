package com.qamar.composablewidgets.ui.lottieexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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