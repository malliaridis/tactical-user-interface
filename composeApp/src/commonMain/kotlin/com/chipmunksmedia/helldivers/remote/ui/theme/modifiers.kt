package com.chipmunksmedia.helldivers.remote.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Custom modifiers that provide additional styling.
 */
object Modifiers {

    /**
     * Border modifier with adjustable border widths for each side.
     *
     * @param top Top border width
     * @param right Right border width
     * @param bottom Bottom border width
     * @param left Left border width
     * @param color Color applied to all border sides
     */
    fun Modifier.border(
        top: Dp = 0.dp,
        right: Dp = 0.dp,
        bottom: Dp = 0.dp,
        left: Dp = 0.dp,
        color: Color,
    ) = composed(
        factory = {
            val density = LocalDensity.current
            val widthTopPx = density.run { top.toPx() }
            val widthRightPx = density.run { right.toPx() }
            val widthBottomPx = density.run { bottom.toPx() }
            val widthLeftPx = density.run { left.toPx() }

            Modifier.drawBehind {
                // val width = size.width
                // val height = size.height - widthTopPx/2

                // Border top
                if (top != 0.dp) drawLine(
                    color = color,
                    start = Offset(x = 0f, y = widthTopPx / 2),
                    end = Offset(x = size.width, y = widthTopPx / 2),
                    strokeWidth = widthTopPx,
                )

                // Border right
                if (right != 0.dp) drawLine(
                    color = color,
                    start = Offset(x = size.width - widthRightPx / 2, y = 0f),
                    end = Offset(x = size.width - widthRightPx / 2, y = size.height),
                    strokeWidth = widthRightPx,
                )

                // Border border bottom
                if (bottom != 0.dp) drawLine(
                    color = color,
                    start = Offset(x = 0f, y = size.height - widthBottomPx / 2),
                    end = Offset(x = size.width, y = size.height - widthBottomPx / 2),
                    strokeWidth = widthBottomPx,
                )

                // Border left
                if (left != 0.dp) drawLine(
                    color = color,
                    start = Offset(x = widthLeftPx / 2, y = 0f),
                    end = Offset(x = widthLeftPx / 2, y = size.height),
                    strokeWidth = widthLeftPx,
                )
            }
        }
    )

    /**
     * Border modifier that applies a border only at the edges.
     *
     * @param length The width of the border on each side.
     * @param color Color applied to the border.
     */
    fun Modifier.cornerBorder(
        length: Dp = 4.dp,
        strokeWidth: Dp = 1.dp,
        color: Color,
    ) = composed(
        factory = {
            val density = LocalDensity.current
            val strokeWidthPx = density.run { strokeWidth.toPx() }
            val lengthPx = density.run { length.toPx() }

            Modifier.drawBehind {
                // val width = size.width
                // val height = size.height - widthTopPx/2
                val halfStrokeWidth = strokeWidthPx / 2

                // top left
                drawLine(
                    color = color,
                    start = Offset(x = 0f, y = halfStrokeWidth),
                    end = Offset(x = lengthPx, y = halfStrokeWidth),
                    strokeWidth = strokeWidthPx,
                )

                drawLine(
                    color = color,
                    start = Offset(x = halfStrokeWidth, y = strokeWidthPx),
                    end = Offset(x = halfStrokeWidth, y = lengthPx),
                    strokeWidth = strokeWidthPx,
                )

                // top right
                drawLine(
                    color = color,
                    start = Offset(x = size.width, y = halfStrokeWidth),
                    end = Offset(x = size.width - lengthPx, y = halfStrokeWidth),
                    strokeWidth = strokeWidthPx,
                )

                drawLine(
                    color = color,
                    start = Offset(x = size.width - halfStrokeWidth, y = strokeWidthPx),
                    end = Offset(x = size.width - halfStrokeWidth, y = lengthPx),
                    strokeWidth = strokeWidthPx,
                )

                // bottom left
                drawLine(
                    color = color,
                    start = Offset(x = halfStrokeWidth, y = size.height),
                    end = Offset(x = halfStrokeWidth, y = size.height - lengthPx),
                    strokeWidth = strokeWidthPx,
                )

                drawLine(
                    color = color,
                    start = Offset(x = strokeWidthPx, y = size.height - halfStrokeWidth),
                    end = Offset(x = lengthPx, y = size.height - halfStrokeWidth),
                    strokeWidth = strokeWidthPx,
                )

                // top right
                drawLine(
                    color = color,
                    start = Offset(x = size.width - halfStrokeWidth, y = 0f),
                    end = Offset(x = size.width - halfStrokeWidth, y = lengthPx),
                    strokeWidth = strokeWidthPx,
                )

                drawLine(
                    color = color,
                    start = Offset(x = size.width - strokeWidthPx, y = halfStrokeWidth),
                    end = Offset(x = size.width - lengthPx, y = halfStrokeWidth),
                    strokeWidth = strokeWidthPx,
                )

                // bottom right
                drawLine(
                    color = color,
                    start = Offset(x = size.width, y = size.height - halfStrokeWidth),
                    end = Offset(x = size.width - lengthPx, y = size.height - strokeWidthPx),
                    strokeWidth = strokeWidthPx,
                )

                drawLine(
                    color = color,
                    start = Offset(x = size.width - halfStrokeWidth, y = size.height - strokeWidthPx),
                    end = Offset(x = size.width - halfStrokeWidth, y = size.height - lengthPx),
                    strokeWidth = strokeWidthPx,
                )
            }
        }
    )
}
