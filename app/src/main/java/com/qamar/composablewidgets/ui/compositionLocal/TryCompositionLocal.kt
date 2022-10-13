package com.qamar.composablewidgets.ui.compositionLocal

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TryCompositionLocal(){
    val user = User("Qamar A. Safadi", 22)
    CompositionLocalProvider(LocalActiveUser provides user) {
        UserInfo()
    }
}

@Preview
@Composable
fun UserInfo() {
    Column {
        Text("Name: " + LocalActiveUser.current.name)
        Text("Age: " + LocalActiveUser.current.age)
    }
}