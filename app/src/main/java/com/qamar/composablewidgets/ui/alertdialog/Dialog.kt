package com.qamar.composablewidgets.ui.alertdialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.window.DialogProperties


@Composable
fun BaseDialog(
    isShow: MutableState<Boolean>,
    cornerShape: Shape? = MaterialTheme.shapes.medium,
    dismissOnBackPressed: Boolean? = false,
    dismissOnClickOutside: Boolean? = false,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
    buttons:@Composable () -> Unit
    ) {
    if (isShow.value) {
        AlertDialog(
            onDismissRequest = {
                isShow.value = false
            },
            title = {
                header()
            },
            text = {
                content()
            },
            buttons = {
                buttons()
            },
            properties = DialogProperties(
                dismissOnBackPress = dismissOnBackPressed!!,
                dismissOnClickOutside = dismissOnClickOutside!!
            ),
            shape = cornerShape!!,
            backgroundColor = backgroundColor,
            contentColor = contentColor
        )
    }
}



