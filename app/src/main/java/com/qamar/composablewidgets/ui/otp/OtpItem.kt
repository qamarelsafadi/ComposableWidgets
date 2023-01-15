package com.qamar.composablewidgets.ui.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.theme.text14WhiteCenter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview
@Composable
fun OtpItem(
    index: Int = 0,
    text: String = "",
    modifier: Modifier,
    textStyle: TextStyle,
    withBorder: Boolean,
    borderWidth: Dp,
    borderColor: Color,
    cornerRadius: Dp,
    itemWidth: Dp,
    itemHeight: Dp,
    itemBackground: Color
) {

    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }

    LaunchedEffect(key1 = cursorSymbol, isFocused) {
        if (isFocused) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }

    Box(
        modifier = Modifier
            .width(itemWidth)
            .height(itemHeight)
            .background(color = itemBackground, shape = RoundedCornerShape(cornerRadius))
            .border(
                if (withBorder) borderWidth else 0.dp,
                if (withBorder) {
                    when {
                        isFocused -> borderColor
                        else -> Color.Transparent
                    }
                } else Color.Transparent,
                RoundedCornerShape(cornerRadius)
            )
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isFocused) cursorSymbol else char,
            textAlign = TextAlign.Center,
            style = textStyle
        )
    }

}
