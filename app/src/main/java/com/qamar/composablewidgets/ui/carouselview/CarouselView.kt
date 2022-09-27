package com.qamar.composablewidgets.ui.carouselview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.qamar.composablewidgets.R
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarouselView() {
    val gradient = Brush.verticalGradient(
        1000f to colorResource(id = R.color.gradinet3),
        1000f to colorResource(id = R.color.gradinet)
    )
    val gradient2 = Brush.verticalGradient(
        1000f to colorResource(id = R.color.gradinet4),
        1000f to colorResource(id = R.color.gradinet2),
    )

    HorizontalPager(
        count = 10,
        // the more you increae the end padding the more
        // content of your other page will show
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(end = 65.dp),
        modifier = Modifier
            .fillMaxSize()

    ) { page ->
        Card(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                // you can control your card height for here if you decrease the ratio it will
                //get more height else will be shorter
                .aspectRatio(0.72f),
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(if (page % 2 == 0) gradient else gradient2)
            ) {
                ProductItem(page = page)
            }
        }
    }
}

@Composable
fun ProductItem(page: Int) {
    Column(
        modifier = Modifier
            .padding(end = 11.dp, start = 11.dp, top = 15.dp)
            .fillMaxWidth(),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Category Name", style = MaterialTheme.typography.h2, color = colorResource(
                    id = R.color.text_alpha
                )
            )
            Image(painter = painterResource(id = R.drawable.favicon), contentDescription = "")

        }
        Text(
            text =
            if (page % 2 == 0) "RED CHAIR" else "WHITE CHAIR",
            style = MaterialTheme.typography.h3, color = Color.White
        )

        Spacer(modifier = Modifier.height(44.dp))
        Image(
            painter = if (page % 2 == 0) painterResource(id = R.drawable.chair1) else painterResource(
                id = R.drawable.chair2
            ), contentDescription = "",
            Modifier.align(Alignment.CenterHorizontally)
        )

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column() {
                repeat(3) {
                    Card(
                        elevation = 3.dp,
                        backgroundColor =
                        if (page % 2 == 0)
                            if (it == 0) Color.Black else if (it == 1) colorResource(id = R.color.red_dark) else Color.White
                        else if (it == 0) colorResource(id = R.color.brown) else if (it == 1) colorResource(
                            id = R.color.gray_light
                        ) else colorResource(id = R.color.brown_light),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .padding(top = 3.dp)
                            .size(20.dp, 20.dp)
                    ) {

                    }
                }
            }

            Card(
                shape = RoundedCornerShape(6.dp), elevation = 0.dp,
                modifier = Modifier
                    .defaultMinSize(minWidth = 73.dp, minHeight = 29.dp)
                    .align(Alignment.Bottom),
                backgroundColor = colorResource(id = R.color.white_alpha)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "350 USD",
                        style = MaterialTheme.typography.h4,
                        color = Color.White
                    )
                }
            }
        }

    }
}

