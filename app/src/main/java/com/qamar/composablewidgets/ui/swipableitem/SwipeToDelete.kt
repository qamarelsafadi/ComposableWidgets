package com.qamar.composablewidgets.ui.swipableitem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Text
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.utils.dpToPx
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun SwipeToDelete() {

    val swipeState =
        rememberSwipeableState(initialValue = 0)
    val context = LocalContext.current
    val anchor = mapOf(
        0f to 0,
        75f.dpToPx(context) to 2
    )
    val scope =
        rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(94.dp)
            .background(Color.Transparent)
            .swipeable(
                state = swipeState,
                anchors = anchor,
                thresholds = { _, _ ->
                    FractionalThreshold(0.3f)
                },
                orientation = Orientation.Horizontal
            )

    ) {
        Box(
            Modifier
                .fillMaxSize()
                .clickable {
                scope.launch {
                    swipeState.animateTo(0)
                }
                }
                .background(Color.White)
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Delete",
                color = Red
            )
        }

        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Black,
            modifier = Modifier
                .fillMaxWidth()
                .height(94.dp)
                .offset {
                    IntOffset(
                        x = swipeState.offset.value.roundToInt(),
                        y= 0
                    )
                }

        ) {

        }
    }
}