package com.qamar.composablewidgets.ui.badgebox

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun BadgeBox() {
    Card(Modifier.fillMaxWidth().height(300.dp)) {
        BadgedBox(badge = {
            Badge {
                Text(text = "0")
            }
        },
        modifier = Modifier.wrapContentSize()) {
            Text(text = "Test Badge")
        }
    }
}