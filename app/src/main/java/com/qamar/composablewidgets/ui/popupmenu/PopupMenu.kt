package com.qamar.composablewidgets.ui.popupmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R


@Composable
fun PopupMenu() {
    var expanded by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.gray)
    ) {
        Row(
            Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Item1")
                    Box {
                        Image(painter = painterResource(R.drawable.ic_baseline_more_vert_24),
                            contentDescription = "", modifier = Modifier.clickable {
                                expanded = !expanded
                            })
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                                Text("Refresh")
                            }
                            DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                                Text("Settings")
                            }
                        }
                    }
                }
            }
        }
    }
}

