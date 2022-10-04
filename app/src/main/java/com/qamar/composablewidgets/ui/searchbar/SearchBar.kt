package com.qamar.composablewidgets.ui.searchbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.ui.theme.ComposableWidgetsTheme
import com.qamar.composablewidgets.ui.topappbar.TopBar


@Composable
fun SearchBar(titleTopAppBar:String = "") {
    var searchableShown by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    Box(
        Modifier.wrapContentHeight()
    ) {
        TopBar(
            title = titleTopAppBar,
            onClickIconSearch = {
                searchableShown = true
            }
        )
        AnimatedVisibility(visible = searchableShown,
            enter = expandHorizontally(expandFrom = Alignment.End) { 0 },
            exit = shrinkHorizontally(
                clip = false,
                // Overwrites the default animation with tween for this shrink animation.
                // Shrink towards the end (i.e. right edge for LTR, left edge for RTL). The default
                // direction for the shrink is towards [Alignment.Start]
                shrinkTowards = Alignment.End,
            ) {
                // Set the end width for the shrink animation to a quarter of the full width.
                20
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                elevation = AppBarDefaults.TopAppBarElevation,
                color = MaterialTheme.colors.primary
            ) {
                TextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier
                                .alpha(ContentAlpha.medium),
                            text = "Search here...",
                            color = Color.White
                        )
                    },
                    textStyle = TextStyle(
                        fontSize = MaterialTheme.typography.subtitle1.fontSize
                    ),
                    singleLine = true,
                    leadingIcon = {
                        IconButton(
                            modifier = Modifier
                                .alpha(ContentAlpha.medium),
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color.White
                            )
                        }
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    searchableShown = false
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Icon",
                                tint = Color.White
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {

                        }
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
                    ))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableWidgetsTheme {
        SearchBar(titleTopAppBar = "Home")
    }
}