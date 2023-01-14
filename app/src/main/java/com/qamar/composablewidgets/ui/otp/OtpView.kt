package com.qamar.composablewidgets.ui.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.theme.Blue
import com.qamar.composablewidgets.ui.theme.BorderBlue
import com.qamar.composablewidgets.ui.theme.text14WhiteCenter

@Preview
@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = text14WhiteCenter,
    otpText: String = "",
    itemCount: Int = 4,
    withBorders: Boolean = true,
    borderColor: Color = BorderBlue,
    cornerRadius: Dp = 11.dp,
    borderWidth: Dp = 2.dp,
    itemSpacing: Dp = 8.dp,
    itemWidth: Dp = 54.dp,
    itemHeight: Dp = 48.dp,
    itemBackground: Color = Blue,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= itemCount) {
                onOtpTextChange.invoke(it, it.length == itemCount)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(itemCount) { index ->
                    OtpItem(
                        index = index,
                        text = otpText,
                        modifier = modifier,
                        textStyle,
                        withBorders,
                        borderWidth,
                        borderColor,
                        cornerRadius,
                        itemWidth,
                        itemHeight,
                        itemBackground
                    )
                    Spacer(modifier = Modifier.width(itemSpacing))
                }
            }
        },
    )
}

