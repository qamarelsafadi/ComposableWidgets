@file:OptIn(ExperimentalAnimationApi::class)

package com.qamar.composablewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.qamar.composablewidgets.ui.alertdialog.BaseDialog
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableWidgetsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.gray)
                ) {
                    val openDialog = remember { mutableStateOf(false) }
                    Button(
                        onClick = { openDialog.value = openDialog.value.not() },
                        Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                    ) {
                        Text(text = "Click to show dialog")
                    }
                    BaseDialog(
                        isShow = openDialog,
                        backgroundColor = Color.White,
                        contentColor = Color.DarkGray,
                        header = { Text(text = "Dialog Title") },
                        dismissOnClickOutside = true,
                        dismissOnBackPressed = true,
                        content = {
                            Text("Here is the content of your dialog ")
                        },
                        buttons = {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    modifier = Modifier.padding(5.dp).weight(1f).height(40.dp),
                                    onClick = {
                                        openDialog.value = false
                                    }) {
                                    Text("Confirm", fontSize = 10.sp)
                                }
                                Button(
                                    modifier =  Modifier.padding(5.dp).weight(1f).height(40.dp),
                                    onClick = {
                                        openDialog.value = false
                                    }) {
                                    Text("Dismiss", fontSize = 10.sp)
                                }
                            }
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        val openDialog = remember { mutableStateOf(false) }
        Button(onClick = { openDialog.value = openDialog.value.not() }) {
            Text(text = "Click to show dialog")
        }


    }
}