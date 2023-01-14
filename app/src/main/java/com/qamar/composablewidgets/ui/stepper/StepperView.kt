package com.qamar.composablewidgets.ui.stepper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.composablewidgets.R

@Preview
@Composable
fun StepperView(
    modifier: Modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
    currentStep: Int = 3,
    stepItems: List<String> = listOf(
        "Step 1 ", "Step 2 ",
        "Step 3", "Step 4"
    )
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Divider(
            Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 10.dp)
                .align(Alignment.TopCenter),
            thickness = 4.dp,
            color = Color.Gray
        )
        LazyRow(
            modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            itemsIndexed(stepItems) { index, item ->
                Step(
                    step = item,
                    isCurrent = index == currentStep,
                    isCompleted = index < currentStep
                )
            }
        }

    }
}

@Composable
fun Step(step: String, isCurrent: Boolean, isCompleted: Boolean) {
    val stepIcon: Int = if (isCurrent) R.drawable.checked
    else {
        if (isCompleted) R.drawable.checked
        else R.drawable.unchecked
    }
    Spacer(modifier = Modifier.width(5.dp))
    Column {
        androidx.compose.foundation.Image(
            painter = painterResource(id = stepIcon), contentDescription = ""
        )
        Text(
            text = step,
            color = Color.White
        )
    }
}
