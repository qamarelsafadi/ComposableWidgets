package com.qamar.composablewidgets.ui.calender

import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.qamar.composablewidgets.R
import java.text.SimpleDateFormat
import java.util.*

@Preview
@Composable
fun Calendar(){
    val dateFormat = SimpleDateFormat("dd:MM:yyyy", Locale.ENGLISH)
    val cal = Calendar.getInstance()
    val date = remember{ mutableStateOf(dateFormat.format(cal.time)) }
    Column(
        modifier =  Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = date.value)
        AndroidView(
            { CalendarView(ContextThemeWrapper(it, R.style.CalenderViewCustom)) },
            update = { views ->
                views.weekDayTextAppearance = R.style.CalenderViewWeekCustomText
                views.firstDayOfWeek = Calendar.SATURDAY
                views.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    cal.set(year, month, dayOfMonth)
                    date.value = dateFormat.format(cal.time).toString()
                }
            })
    }
}