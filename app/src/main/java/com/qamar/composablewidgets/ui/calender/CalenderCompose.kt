package com.qamar.composablewidgets.ui.calender

import android.widget.CalendarView
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Preview
@Composable
fun Calender(){
    AndroidView(
        { CalendarView(it) })
}