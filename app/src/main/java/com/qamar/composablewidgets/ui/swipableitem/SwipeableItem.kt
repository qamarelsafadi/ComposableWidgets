package com.qamar.composablewidgets.ui.swipableitem

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.theme.Bg
import com.qamar.composablewidgets.ui.theme.Teal200
import com.qamar.composablewidgets.ui.theme.Typography


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun SwipeList() {
    Scaffold(
        backgroundColor = Color.White, contentColor = Color.White
    ) {
        Box(modifier = Modifier.padding(it)) {
            val list = remember { mutableStateListOf(1, 2,3,4,5,6) }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
            ) {
                LazyColumn(contentPadding = PaddingValues(vertical = 6.dp, horizontal = 16.dp)) {
                    itemsIndexed(list) { index,item ->
                        val dismissState = rememberDismissState(confirmStateChange = {
                            if (it == DismissValue.DismissedToEnd) {
                                list.remove(list[index])
                            }
                            it != DismissValue.DismissedToEnd
                        })
                        SwipeItem(dismissState, swipeButton = {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(Color.White)
                                    .padding(horizontal = 20.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text = "Delete", style = Typography.button, color = Color.Red
                                )
                            }
                        }) {
                            Card(
                                elevation = 0.dp,
                                shape = RoundedCornerShape(8.dp),
                                backgroundColor = Teal200,
                                modifier = Modifier
                                    .height(94.dp)
                                    .fillMaxWidth()
                            ) {
                                ListItem(text = {
                                    Text("Swipe$item", style = Typography.h3, color = Color.Black)
                                }, secondaryText = { Text("Swipe me right !", color = Color.Black) })
                            }
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeItem(
    dismissState: DismissState,
    swipeButton: @Composable RowScope.() -> Unit,
    swipeContent: @Composable RowScope.() -> Unit
) {
    SwipeToDismiss(state = dismissState,
        modifier = Modifier.padding(vertical = 4.dp),
        directions = setOf(DismissDirection.StartToEnd),
        background = {
            swipeButton()
        },
        dismissContent = {
            swipeContent()
        })
}