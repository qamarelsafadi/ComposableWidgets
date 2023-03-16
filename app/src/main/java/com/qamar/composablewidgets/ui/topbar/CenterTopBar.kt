package com.qamar.composablewidgets.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CenterToolbar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Home")
        },
        navigationIcon = {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
        })
}