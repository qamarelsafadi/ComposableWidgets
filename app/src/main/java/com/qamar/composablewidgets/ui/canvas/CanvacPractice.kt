package com.qamar.composablewidgets.ui.canvas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import  androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AndroidCanvas() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Canvas(modifier = Modifier
            .size(300.dp)
            .align(Alignment.BottomCenter)) {
            drawArc(
                color = Color(0xFF3DDB85),
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
            )

            drawCircle(
                color = Color.White,
                radius = 23f,
                center = Offset(
                    this.size.width * .70f,
                    this.size.height * .35f
                ),
            )
            drawCircle(
                color = Color.White,
                radius = 23f,
                center = Offset(
                    (this.size.width * .30f),
                    this.size.height * .35f
                ),
            )

            drawLine(
                color =  Color(0xFF3DDB85),
                start = Offset(
                    this.size.width * .100f,
                   0f
                ),
                end = Offset(
                    this.size.width * .50f,
                    this.size.height *.40f
                ),
                strokeWidth = 30f,
                cap = StrokeCap.Round

            )
            drawLine(
                color =  Color(0xFF3DDB85),
                start = Offset(
                    this.size.width * .50f,
                    this.size.height *.40f
                ),
                end = Offset(
                    this.size.width * .80f,
                    this.size.height *-.10f
                ),
                strokeWidth = 30f,
                cap = StrokeCap.Round

            )

        }
    }
}