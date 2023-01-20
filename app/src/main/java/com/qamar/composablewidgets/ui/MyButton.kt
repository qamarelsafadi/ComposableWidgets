package com.qamar.composablewidgets.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.relay.compose.CrossAxisAlignment

@Composable
fun MyButton(
    text: String,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Blue,
    roundedRadius: Dp = 8.dp,
    height: Dp = 46.dp,
    trailingIcon: @Composable() () -> Unit = {},
    leadingIcon: @Composable() () -> Unit = {},
    onClick: () -> Unit
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(roundedRadius)
    ) {
            Box(modifier = Modifier
                .height(height = height)
                .clickable {
                    onClick()
                }
                .padding(horizontal = 10.dp)) {
                Row(
                   horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    leadingIcon()
                    Text(text,
                    color = textColor)
                    trailingIcon()
                }
            }
        }
}




