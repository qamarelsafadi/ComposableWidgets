package com.qamar.composablewidgets.ui.button

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.theme.buttonText
import com.qamar.composablewidgets.ui.theme.text14WhiteCenter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ElasticButton(
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
        .width(167.dp)
        .requiredHeight(48.dp),
    colorBg: Color = Color.Black,
    textColor: Color = Color.White,
    isLoading: Boolean = false
) {
    // ElasticView(onClick = { onClick() }) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorBg)
    ) {
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
                Text(
                    text = title,
                    color = textColor,
                    style = text14WhiteCenter
                )
            }
    }
    // }
}