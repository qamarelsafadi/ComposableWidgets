package com.qamar.composablewidgets.ui.progressbutton

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R
import com.qamar.composablewidgets.ui.progressbutton.components.ProgressButtonComponents

@Composable
fun ProgressButton() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        var loading by remember {
            mutableStateOf(false)
        }
        Box() {
            ProgressButtonComponents(
                onClick = { loading = !loading },
                modifier = Modifier
                    .padding(16.dp)
                    .height(46.dp)
                    .align(Alignment.Center),
                loading = loading,
                color = R.color.purple_200,
                progressColor = R.color.white
            ) {
                Text(
                    color = colorResource(id = R.color.white),
                    text = "Refresh"
                )
            }
        }
    }

}