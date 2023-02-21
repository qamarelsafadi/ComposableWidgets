package com.qamar.composablewidgets.ui.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.qamar.composablewidgets.ui.theme.Bg
import com.qamar.composablewidgets.ui.theme.Blue
import com.qamar.composablewidgets.ui.theme.BorderBlue

@Preview(showBackground = true)
@Composable
fun ColorfulText(){
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(Blue)){
                append("Hello")
            }
            withStyle(SpanStyle(Bg)){
                append("Compose")
            }
            withStyle(SpanStyle(BorderBlue)){
                append("World!!!!")
            }
        }
    )
}