package com.qamar.composablewidgets.ui.composeinxml

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.ComposeView
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import com.qamar.composablewidgets.ui.verticalhorizontallist.VerticalHorizontalList

class ComposeXmlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                VerticalHorizontalList()
            }
        }
    }
}