package com.malliaridis.tui.ui.components.media

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun AudioVisualizer(
    value: Float,
    modifier: Modifier = Modifier,
    onValueChange: (Float) -> Unit,
    onValueChangeFinished: () -> Unit,
    amplitudes: List<Float>,
) = Canvas(modifier = modifier) {
    val height = size.height
    val width = size.width
    val numSamples = amplitudes.size
    val stepSize = width / numSamples

    val path = Path()
    path.moveTo(0f, height / 2)

    amplitudes.forEachIndexed { index, amplitude ->
        val x = index * stepSize
        val y = height / 2 - amplitude * height / 2
        path.lineTo(x, y)
    }

    drawPath(
        path = path,
        color = Color.Blue,
        style = Stroke(width = 2f)
    )
}
