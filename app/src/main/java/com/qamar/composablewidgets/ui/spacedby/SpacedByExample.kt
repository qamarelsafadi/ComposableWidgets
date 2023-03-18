package com.qamar.composablewidgets.ui.spacedby

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SpacedBy() {

    var isSpacedByEnabled by remember {
        mutableStateOf(false)
    }

    val animatedSpacedByValue: Dp by animateDpAsState(
        targetValue =
        if (isSpacedByEnabled) 10.dp else 0.dp
    )

    Row(Modifier.clickable {
        isSpacedByEnabled = !isSpacedByEnabled
    },
    horizontalArrangement = Arrangement.spacedBy(animatedSpacedByValue)
        ) {
        repeat(4) {
            Card(
                Modifier.size(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black)
            ) {

            }
        }
    }
}