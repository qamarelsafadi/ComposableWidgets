package com.qamar.composablewidgets.ui.blurimage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.blurimage.component.BlurImageComponent

@Composable
fun BlurImage() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        BlurImageComponent()
    }
}