package com.qamar.composablewidgets.ui.ratingbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.qamar.composablewidgets.R

@Composable
fun RatingView(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = R.drawable.ic_heart,
    iconPadding: Dp = 0.dp,
    iconSize: Dp = 64.dp,
    unselectedColor: Color = Color.Gray,
    selectedColor: Color = Color.Red
) {
    val (rating, setRating) = remember { mutableStateOf(-1) }

    Row(modifier) {
        repeat(5) { index ->
            Icon(
                modifier = Modifier
                    .padding(iconPadding)
                    .size(iconSize)
                    .clickable {
                        setRating(index)
                    },
                painter = rememberAsyncImagePainter(model = icon),
                contentDescription = "rating ${index + 1}",
                tint = if (index <= rating) selectedColor else unselectedColor
            )
        }
    }
}