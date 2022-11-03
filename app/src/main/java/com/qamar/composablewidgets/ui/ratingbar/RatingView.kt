package com.qamar.composablewidgets.ui.ratingbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
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
    unselectedColor: Color = Color.LightGray,
    selectedColor: Color = Color.Red,
    maxRating: Int = 5,
    ratingPercentage: Float // 0f to 1f
) {
    val finalRating = remember(ratingPercentage, maxRating) { ratingPercentage * maxRating }

    Row(modifier) {
        repeat(maxRating) { index ->
            val (widthMultiplier, setWidthMultiplier) = remember { mutableStateOf(0f) }

            LaunchedEffect(index, finalRating) {
                setWidthMultiplier(getWidthMultiplier(finalRating, index))
            }

            Box {
                if (widthMultiplier != 1f) {
                    Icon(
                        modifier = Modifier.padding(iconPadding).size(iconSize),
                        painter = rememberAsyncImagePainter(model = icon),
                        contentDescription = "",
                        tint = unselectedColor
                    )
                }

                Icon(
                    modifier = Modifier
                        .padding(iconPadding)
                        .size(iconSize)
                        .clip(GenericShape { size, _ ->
                            addRect(
                                Rect(
                                    offset = Offset.Zero,
                                    size = Size(
                                        width = (size.width * widthMultiplier),
                                        height = size.height
                                    )
                                )
                            )
                        }),
                    painter = rememberAsyncImagePainter(model = icon),
                    contentDescription = "",
                    tint = if (index < finalRating) selectedColor else unselectedColor
                )
            }
        }
    }
}

fun getWidthMultiplier(finalRating: Float, index: Int): Float {
    val fullRating = finalRating.toInt()
    val fractionalRating = finalRating - fullRating

    return when {
        index < fullRating -> 1f      // full rating case
        index > fullRating -> 1f      // no rating case
        else -> fractionalRating      // fractional rating case
    }

}
