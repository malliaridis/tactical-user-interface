package com.chipmunksmedia.helldivers.remote.ui.components.stratagems

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import helldiversremote.composeapp.generated.resources.Res
import helldiversremote.composeapp.generated.resources.dial_bottom
import helldiversremote.composeapp.generated.resources.dial_center
import helldiversremote.composeapp.generated.resources.dial_left
import helldiversremote.composeapp.generated.resources.dial_right
import helldiversremote.composeapp.generated.resources.dial_top
import helldiversremote.composeapp.generated.resources.dial_universal_pressed
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.math.absoluteValue
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@Serializable
enum class DialPadStyle {
    SwipePad,
    Circular,
    Rectangular,
}

@Composable
fun DialPad(
    modifier: Modifier = Modifier,
    style: DialPadStyle = DialPadStyle.SwipePad,
    onDirectionDetect: (Direction) -> Unit,
) {
    when (style) {
        DialPadStyle.SwipePad -> DialPadSwipe(
            modifier = modifier,
            onDirectionDetect = onDirectionDetect,
        )

        DialPadStyle.Circular -> DialPadCircleDrawables(
            modifier = modifier,
            onClick = onDirectionDetect,
        )

        DialPadStyle.Rectangular -> DialPadRectangular(
            modifier = modifier,
            onClick = onDirectionDetect,
        )
    }
}

@Composable
fun DialPad3(
    modifier: Modifier = Modifier,
    innerFraction: Float = 0.45f,
    cornerRadius: Dp = 2.dp,
    gapSize: Dp = 8.dp,
) {
    var pressedButton by remember { mutableStateOf(Direction.None) }

    Canvas(
        modifier = modifier.pointerInput("dial-input") {
            detectTapGestures(
                onPress = { offset ->
                    // TODO Implement press behavior
                },
            )
        },
    ) {
        val halfSize = size / 2f
        val innerSize = size * innerFraction
        val cornerRadiusPx = cornerRadius.toPx()
        val gapSizePx = gapSize.toPx()
        val insetValue = (cornerRadiusPx + gapSizePx) / 2

        val path = Path().apply {
            val reducedSize = Size(halfSize.width - gapSizePx / 2, halfSize.height - gapSizePx / 2)
            addRect(Rect(Offset(0f, 0f), reducedSize))
            op(
                path1 = this,
                path2 = Path().apply {
                    val reducedSize2 = Size(size.width - cornerRadiusPx * 2, size.height - cornerRadiusPx * 2)
                    addOval(Rect(Offset(cornerRadiusPx, cornerRadiusPx), reducedSize2))
                },
                operation = PathOperation.Intersect,
            )
            op(
                path1 = this,
                path2 = Path().apply {
                    addOval(
                        Rect(
                            Offset(
                                halfSize.width - (innerSize.width / 2f),
                                halfSize.height - (innerSize.height / 2f)
                            ), innerSize
                        )
                    )
                },
                operation = PathOperation.Difference,
            )
        }

        translate(top = -insetValue) {
            rotate(degrees = 45f, pivot = Offset(halfSize.width, halfSize.height)) {
                drawPath(path, Color(0xFF494740))
                drawOutline(
                    outline = Outline.Generic(path),
                    color = Color(0xFF7A776F),
                    style = Stroke(
                        width = cornerRadiusPx,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                    ),
                )
            }
        }

        translate(left = insetValue) {
            rotate(degrees = 135f, pivot = Offset(halfSize.width, halfSize.height)) {
                drawPath(path, Color(0xFF494740))
                drawOutline(
                    outline = Outline.Generic(path),
                    color = Color(0xFF7A776F),
                    style = Stroke(
                        width = cornerRadiusPx,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                    ),
                )
            }
        }

        translate(top = insetValue) {
            rotate(degrees = 225f, pivot = Offset(halfSize.width, halfSize.height)) {
                drawPath(path, Color(0xFF494740))
                drawOutline(
                    outline = Outline.Generic(path),
                    color = Color(0xFF7A776F),
                    style = Stroke(
                        width = cornerRadiusPx,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                    ),
                )
            }
        }

        translate(left = -insetValue) {
            rotate(degrees = 315f, pivot = Offset(halfSize.width, halfSize.height)) {
                drawPath(path, Color(0xFF494740))
                drawOutline(
                    outline = Outline.Generic(path),
                    color = Color(0xFF7A776F),
                    style = Stroke(
                        width = cornerRadiusPx,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                    ),
                )
            }
        }
    }
}

/**
 * This is the circular dial pad with drawables used as buttons.
 *
 * Due to the 3D effect of button drawables small adjustments are necessary that are not optimally solved.
 *
 * @param modifier The main modifier of the composable
 * @param gapFraction Distance between buttons relative to size of composable.
 * @param onClick On click callback used for handling clicks on any direction of the dial pad. A click is called on
 * press and resets on release.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun DialPadCircleDrawables(
    onClick: (Direction) -> Unit,
    modifier: Modifier = Modifier,
    gapFraction: Float = 0.04f,
) {
    val maxSize = 0.5f - gapFraction
    val maxSizePressed = maxSize - 0.02f

    var pressedDirection by remember { mutableStateOf(Direction.None) }

    Box(
        modifier = modifier
            .aspectRatio(1f),
    ) {
        val isTop = pressedDirection == Direction.Up
        Image(
            modifier = Modifier
                .fillMaxSize(if (isTop) maxSizePressed else maxSize)
                .offset(y = if (isTop) (-20).dp else (-24).dp)
                .rotate(45f)
                .align(Alignment.TopCenter)
                .pointerInput("top-pointer") {
                    detectTapGestures(onPress = {
                        pressedDirection = Direction.Up
                        onClick(Direction.Up)
                        tryAwaitRelease()
                        pressedDirection = Direction.None
                    })
                },
            painter = painterResource(
                if (isTop) Res.drawable.dial_universal_pressed
                else Res.drawable.dial_top,
            ),
            contentDescription = "dial-top",
        )

        val isLeft = pressedDirection == Direction.Left
        Image(
            modifier = Modifier
                .fillMaxSize(if (isLeft) maxSizePressed else maxSize)
                .offset(
                    x = if (isLeft) (-20).dp else (-24).dp,
                    y = if (isLeft) 2.dp else 0.dp,
                )
                .rotate(315f)
                .align(Alignment.CenterStart)
                .pointerInput("left-pointer") {
                    detectTapGestures(onPress = {
                        pressedDirection = Direction.Left
                        onClick(Direction.Left)
                        tryAwaitRelease()
                        pressedDirection = Direction.None
                    })
                },
            painter = painterResource(
                if (isLeft) Res.drawable.dial_universal_pressed
                else Res.drawable.dial_left,
            ),
            contentDescription = "dial-left",
        )

        val isRight = pressedDirection == Direction.Right
        Image(
            modifier = Modifier
                .fillMaxSize(if (isRight) maxSizePressed else maxSize)
                .offset(
                    x = if (isRight) 20.dp else 24.dp,
                    y = if (isRight) 2.dp else 0.dp,
                )
                .rotate(135f)
                .align(Alignment.CenterEnd)
                .pointerInput("right-pointer") {
                    detectTapGestures(onPress = {
                        pressedDirection = Direction.Right
                        onClick(Direction.Right)
                        tryAwaitRelease()
                        pressedDirection = Direction.None
                    })
                },
            painter = painterResource(
                if (isRight) Res.drawable.dial_universal_pressed
                else Res.drawable.dial_right,
            ),
            contentDescription = "dial-right",
        )

        val isBottom = pressedDirection == Direction.Down
        Image(
            modifier = Modifier
                .fillMaxSize(if (isBottom) maxSizePressed else maxSize)
                .offset(y = 24.dp)
                .rotate(225f)
                .align(Alignment.BottomCenter)
                .pointerInput("bottom-pointer") {
                    detectTapGestures(onPress = {
                        pressedDirection = Direction.Down
                        onClick(Direction.Down)
                        tryAwaitRelease()
                        pressedDirection = Direction.None
                    })
                },
            painter = painterResource(
                if (isBottom) Res.drawable.dial_universal_pressed
                else Res.drawable.dial_bottom,
            ),
            contentDescription = "dial-bottom",
        )

        val isCenter = pressedDirection == Direction.Center
        Image(
            modifier = Modifier
                .fillMaxSize(3 / 8f)
                .align(Alignment.Center)
                .offset(y = if (isCenter) 2.dp else 0.dp)
                .pointerInput("left-pointer") {
                    detectTapGestures(onPress = {
                        pressedDirection = Direction.Center
                        onClick(Direction.Center)
                        tryAwaitRelease()
                        pressedDirection = Direction.None
                    })
                },
            painter = painterResource(
                if (isCenter) Res.drawable.dial_universal_pressed
                else Res.drawable.dial_center,
            ),
            contentDescription = "dial-center",
        )
    }
}

/**
 * A dial pad that uses swipe gestures for directional input.
 *
 * @param onDirectionDetect Callback function for when a direction is detected by a swipe gesture or double tap (for
 * [Direction.Center]). User has to end the drag gesture before the next swipe direction can be detected.
 * @param modifier Modifier of the composable.
 * @param shape The dial pad shape. Defaults to [DialPadDefaults.swipePadShape].
 * @param dragThreshold Threshold for the minimum drag distance before swipe detection. Prevents from accidental
 * swipe detection on very short drag distances. When setting this value to high, no swipe directions will be detected.
 */
@Composable
fun DialPadSwipe(
    onDirectionDetect: (Direction) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = DialPadDefaults.swipePadShape,
    dragThreshold: Int = 50,
) {
    var swipeHandled by remember { mutableStateOf(false) }
    var accumulatedOffset by remember { mutableStateOf(Offset.Zero) }

    Surface(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { onDirectionDetect(Direction.Center) },
                )
                detectDragGestures(
                    onDragStart = { swipeHandled = false },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        if (swipeHandled) return@detectDragGestures

                        accumulatedOffset += dragAmount

                        val direction = getSwipeDirection(accumulatedOffset, dragThreshold)
                        if (direction != Direction.None) {
                            swipeHandled = true
                            onDirectionDetect(direction)

                            // Reset accumulated offset after swipe is detected
                            accumulatedOffset = Offset.Zero
                        }
                    },
                    onDragEnd = { swipeHandled = false },
                )
            },
        shape = shape,
        color = CustomColors.dialogContainerColor,
        border = BorderStroke(2.dp, CustomColors.borderColor),
        content = {},
    )
}

/**
 * Returns the swipe direction based on the [dragAmount]. If [dragAmount] in any direction is below [distanceThreshold],
 * then [Direction.None] is returned.
 *
 * @param dragAmount Drag offset to use for determining the direction
 * @param distanceThreshold Minimum distance required for detecting a direction
 * @return The [Direction] the [dragAmount] is dragged at. [Direction.None] is returned if [dragAmount] is not dragged
 * far enough.
 */
private fun getSwipeDirection(dragAmount: Offset, distanceThreshold: Int): Direction {
    val (deltaX, deltaY) = dragAmount

    return when {
        deltaX.absoluteValue < distanceThreshold && deltaY.absoluteValue < distanceThreshold -> Direction.None
        deltaX.absoluteValue > deltaY.absoluteValue -> if (deltaX > 0) Direction.Right else Direction.Left
        else -> if (deltaY > 0) Direction.Down else Direction.Up
    }
}

@Composable
fun DialPadRectangular(
    modifier: Modifier = Modifier,
    onClick: (Direction) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            RectangularButton(
                modifier = Modifier.weight(3f),
                onClick = { onClick(Direction.Left) },
            )
            Column(
                modifier = Modifier.weight(5f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                RectangularButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onClick(Direction.Up) },
                )
                RectangularButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onClick(Direction.Down) },
                )
            }
            RectangularButton(
                modifier = Modifier.weight(3f),
                onClick = { onClick(Direction.Right) },
            )
        }
        RectangularButton(
            modifier = Modifier.weight(1f),
            onClick = { onClick(Direction.Center) }
        )
    }
}

@Composable
private fun RectangularButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    var pressed by remember { mutableStateOf(false) }

    var outerModifier = modifier.pointerInput(Unit) {
        detectTapGestures(
            onPress = {
                pressed = true
                onClick()
                tryAwaitRelease()
                pressed = false
            }
        )
    }

    var innerModifier = Modifier.fillMaxSize()

    if (pressed) {
        outerModifier = outerModifier.padding(top = 4.dp)
        innerModifier = innerModifier.border(
            width = 1.5.dp,
            color = CustomColors.seedColor,
            shape = RoundedCornerShape(8.dp),
        )
            .background(
                color = CustomColors.dialPadContainerColorPressed,
                shape = RoundedCornerShape(8.dp),
            )
    } else {
        outerModifier = outerModifier
            .background(
                color = CustomColors.dialPadBackgroundColor,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(top = 1.5.dp, start = 1.5.dp, end = 1.5.dp, bottom = 4.dp)
        innerModifier = innerModifier.background(
            color = CustomColors.dialPadContainerColor,
            shape = RoundedCornerShape(8.dp),
        )
    }

    Box(modifier = outerModifier) {
        Box(modifier = innerModifier)
    }
}


@Composable
fun DialPad(
    modifier: Modifier = Modifier,
    centerFraction: Float = .4f,
    padding: Dp = 16.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: (DialPadButton) -> Unit,
) {
    val scope: DialPadScope = remember { LocalDialPadScope(padding, centerFraction) }
    with(scope) {

        Canvas(
            modifier = modifier
                .defaultMinSize(
                    minWidth = DialPadDefaults.minWidth,
                    minHeight = DialPadDefaults.minHeight,
                )
                .alpha(.7f)
                .dialPadClickable(
                    interactionSource = interactionSource,
                    onClick = onClick,
                ),
            onDraw = {
                val fractionWidth = size.width * centerFraction
                val fractionHeight = size.height * centerFraction

                // TODO Get pressed button to draw with correct color

                drawButtonTop(
                    centerWidth = fractionWidth,
                    centerHeight = fractionHeight,
                    padding = padding,
                    color = color,
                )

                drawButtonEnd(
                    centerWidth = fractionWidth,
                    centerHeight = fractionHeight,
                    padding = padding,
                    color = color,
                )

                drawButtonBottom(
                    centerWidth = fractionWidth,
                    centerHeight = fractionHeight,
                    padding = padding,
                    color = color,
                )

                drawButtonStart(
                    centerWidth = fractionWidth,
                    centerHeight = fractionHeight,
                    padding = padding,
                    color = color,
                )

                drawButtonCenter(
                    width = fractionWidth,
                    height = fractionHeight,
                    color = color,
                )
            }
        )
    }
}

private fun DrawScope.drawButtonTop(
    centerWidth: Float,
    centerHeight: Float,
    padding: Dp,
    color: Color,
) {
    val path = Path().apply {
        val width = this@drawButtonTop.size.width
        // Use double the height to have only a half circle
        val height = this@drawButtonTop.size.height
        val innerWidth = centerWidth + padding.toPx()
        val innerHeight = centerHeight + padding.toPx()
        addOval(
            Rect(
                left = 0f,
                top = 0f,
                right = width,
                bottom = height,
            )
        )
        // Cut inner circle
        op(
            path1 = this,
            path2 = Path().apply {
                addOval(
                    Rect(
                        left = 0f,
                        top = 0f,
                        right = innerWidth,
                        bottom = innerHeight,
                    )
                )
                translate(Offset((width - innerWidth) / 2, (height - innerHeight) / 2))
            },
            operation = PathOperation.Difference,
        )

        // Cut slice
        val gapSizePx = padding.toPx() / (4 * sin(atan(height / width)))
        op(
            path1 = this,
            path2 = Path().apply {
                lineTo(x = 0f, y = 0f)
                lineTo(x = gapSizePx, y = 0f)
                lineTo(x = width / 2 + gapSizePx, y = height / 2)
                lineTo(x = width / 2 - gapSizePx, y = height / 2)
                lineTo(x = width - gapSizePx, y = 0f)
                lineTo(x = width, y = 0f)
                lineTo(x = width, y = height)
                lineTo(x = 0f, y = height)
                close()
            },
            operation = PathOperation.Difference,
        )
    }
    /*
        val scaleMatrix = Matrix()
        val scale = 1f - 8.dp.toPx() / this.size.width
        scaleMatrix.scale(x = scale, y = scale)
        path.transform(scaleMatrix)
        path.translate(Offset(x = 4.dp.toPx(), y = 4.dp.toPx()))

        path.translate(Offset(0f, 2.dp.toPx()))
        drawPath(
            path = path,
            color = Color(0xFF797776),
            style = Stroke(
                width = 8.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round,
            )
        )
        path.translate(Offset(0f, 2.dp.toPx()))
        drawPath(
            path = path,
            color = Color(0xFF797776),
            style = Stroke(
                width = 8.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round,
            )
        )

        val scaleMatrix2 = Matrix()
        scaleMatrix2.scale(1f / scale)
        path.transform(scaleMatrix2)
        path.translate(Offset(x = (-4).dp.toPx(), y = (-4).dp.toPx()))

        // path.translate(Offset(0f, (-1).dp.toPx()))

        drawPath(
            path = path,
            color = Color(0xFF494740),
        )

        drawPath(
            path = path,
            color = Color(0xFF797776),
            style = Stroke(
                width = 4.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round,
            )
        )
     */

    drawIntoCanvas { canvas ->
        canvas.drawOutline(
            outline = Outline.Generic(path),
            paint = Paint().apply {
                this.color = Color.Green
                pathEffect = PathEffect.cornerPathEffect(path.getBounds().maxDimension / 3)
            }
        )
    }
}

private fun DrawScope.drawButtonBottom(
    centerWidth: Float,
    centerHeight: Float,
    padding: Dp,
    color: Color,
) {
    val path = Path().apply {
        val width = this@drawButtonBottom.size.width
        // Use double the height to have only a half circle
        val height = this@drawButtonBottom.size.height
        val innerWidth = centerWidth + padding.toPx()
        val innerHeight = centerHeight + padding.toPx()
        addOval(
            Rect(
                left = 0f,
                top = 0f,
                right = width,
                bottom = height,
            )
        )
        // Cut inner circle
        op(
            path1 = this,
            path2 = Path().apply {
                addOval(
                    Rect(
                        left = 0f,
                        top = 0f,
                        right = innerWidth,
                        bottom = innerHeight,
                    )
                )
                translate(Offset((width - innerWidth) / 2, (height - innerHeight) / 2))
            },
            operation = PathOperation.Difference,
        )
        // Cut slice
        val gapSizePx = padding.toPx() / (4 * sin(atan(height / width)))
        op(
            path1 = this,
            path2 = Path().apply {
                lineTo(x = 0f, y = 0f)
                lineTo(x = width, y = 0f)
                lineTo(x = width, y = height)
                lineTo(x = width - gapSizePx, y = height)
                lineTo(x = width / 2 - gapSizePx, y = height / 2)
                lineTo(x = width / 2 + gapSizePx, y = height / 2)
                lineTo(x = gapSizePx, y = height)
                lineTo(x = 0f, y = height)
                close()
            },
            operation = PathOperation.Difference,
        )
    }
    drawPath(path, color)
}

private fun DrawScope.drawButtonStart(
    centerWidth: Float,
    centerHeight: Float,
    padding: Dp,
    color: Color,
) {
    val path = Path().apply {
        // Use double the width to have only a half circle
        val width = this@drawButtonStart.size.width
        val height = this@drawButtonStart.size.height
        val innerWidth = centerWidth + padding.toPx()
        val innerHeight = centerHeight + padding.toPx()
        addOval(
            Rect(
                left = 0f,
                top = 0f,
                right = width,
                bottom = height,
            )
        )
        // Cut inner circle
        op(
            path1 = this,
            path2 = Path().apply {
                addOval(
                    Rect(
                        left = 0f,
                        top = 0f,
                        right = innerWidth,
                        bottom = innerHeight,
                    )
                )
                translate(Offset((width - innerWidth) / 2, (height - innerHeight) / 2))
            },
            operation = PathOperation.Difference,
        )
        // Cut slice
        val gapSizePx = padding.toPx() / (4 * sin(atan(width / height)))
        op(
            path1 = this,
            path2 = Path().apply {
                lineTo(x = 0f, y = 0f)
                lineTo(x = width, y = 0f)
                lineTo(x = width, y = height)
                lineTo(x = 0f, y = height)
                lineTo(x = 0f, y = height - gapSizePx)
                lineTo(x = width / 2, y = height / 2 - gapSizePx)
                lineTo(x = width / 2, y = height / 2 + gapSizePx)
                lineTo(x = 0f, y = gapSizePx)
                close()
            },
            operation = PathOperation.Difference,
        )
    }
    drawPath(path, color)
}

private fun DrawScope.drawButtonEnd(
    centerWidth: Float,
    centerHeight: Float,
    padding: Dp,
    color: Color,
) {
    val path = Path().apply {
        // Use double the width to have only a half circle
        val width = this@drawButtonEnd.size.width
        val height = this@drawButtonEnd.size.height
        val innerWidth = centerWidth + padding.toPx()
        val innerHeight = centerHeight + padding.toPx()
        addOval(
            Rect(
                left = 0f,
                top = 0f,
                right = width,
                bottom = height,
            )
        )
        // Cut inner circle
        op(
            path1 = this,
            path2 = Path().apply {
                addOval(
                    Rect(
                        left = 0f,
                        top = 0f,
                        right = innerWidth,
                        bottom = innerHeight,
                    )
                )
                translate(Offset((width - innerWidth) / 2, (height - innerHeight) / 2))
            },
            operation = PathOperation.Difference,
        )
        // Cut slice
        val gapSizePx = padding.toPx() / (4 * sin(atan(width / height)))
        op(
            path1 = this,
            path2 = Path().apply {
                lineTo(x = 0f, y = 0f)
                lineTo(x = width, y = 0f)
                lineTo(x = width, y = gapSizePx)
                lineTo(x = width / 2, y = height / 2 + gapSizePx)
                lineTo(x = width / 2, y = height / 2 - gapSizePx)
                lineTo(x = width, y = height - gapSizePx)
                lineTo(x = width, y = height)
                lineTo(x = 0f, y = height)
                close()
            },
            operation = PathOperation.Difference,
        )
    }
    drawPath(path, color)
}

private fun DrawScope.drawButtonCenter(
    width: Float,
    height: Float,
    color: Color,
) {
    val path = Path().apply {
        // Use double the width to have only a half circle
        val canvasWidth = this@drawButtonCenter.size.width
        val canvasHeight = this@drawButtonCenter.size.height
        val offsetX = (canvasWidth - width) / 2
        val offsetY = (canvasHeight - height) / 2
        addOval(
            Rect(
                left = offsetX,
                top = offsetY,
                right = offsetX + width,
                bottom = offsetY + height,
            )
        )
    }
    drawPath(path, color)
}

interface DialPadScope {

    fun Modifier.dialPadClickable(
        interactionSource: MutableInteractionSource,
        onClick: (button: DialPadButton) -> Unit,
    ): Modifier
}

internal class LocalDialPadScope(
    private val padding: Dp,
    private val centerFraction: Float,
) : DialPadScope {

    override fun Modifier.dialPadClickable(
        interactionSource: MutableInteractionSource,
        onClick: (button: DialPadButton) -> Unit,
    ): Modifier = this.pointerInput(Unit) {
        detectTapGestures(
            onPress = { offset ->
                val padButton = getDialPadButton(
                    offset = offset,
                    paddingPx = padding.toPx(),
                    centerFraction = centerFraction,
                )
                println(padButton)

                if (padButton == null) return@detectTapGestures
                val press = PressInteraction.Press(pressPosition = offset)
                interactionSource.emit(press)

                val released = tryAwaitRelease()
                interactionSource.tryEmit(PressInteraction.Release(press))

                // TODO Update state to show button pressed state.
            },
        )
    }

    /**
     * Function that returns the [DialPadButton] for a specific offset in the current [PointerInputScope]. This function
     * works only inside a [DialPad].
     *
     * @param offset The offset / position of the pointer.
     * @param paddingPx The padding in pixels of the [DialPad].
     * @param centerFraction The fraction used for the center button.
     *
     * @return Returns a [DialPadButton] if the [offset] is on the surface of a button. `null` if the pointer input is
     * not on a valid area.
     */
    internal fun PointerInputScope.getDialPadButton(
        offset: Offset,
        paddingPx: Float,
        centerFraction: Float,
    ): DialPadButton? {

        val centerOffset = Offset(x = size.width / 2f, y = size.height / 2f)
        val newOffset = (offset - centerOffset)

        // Check if tap offset is inside clickable area
        val isPointInsideLargeCircle =
            (newOffset.x / (size.width / 2)).pow(2) + (newOffset.y / (size.height / 2)).pow(2) < 1
        if (!isPointInsideLargeCircle) return null // outside button area

        // val paddingPx = padding.toPx()
        val onCenterButton =
            (newOffset.x / (size.width * centerFraction / 2)).pow(2) + (newOffset.y / (size.height * centerFraction / 2)).pow(
                2
            ) < 1
        val onCenterCircleWithPaddings =
            (newOffset.x / ((size.width * centerFraction + paddingPx) / 2)).pow(2) + (newOffset.y / ((size.height * centerFraction + paddingPx) / 2)).pow(
                2
            ) < 1
        val isPointBetweenCircles = !onCenterButton && onCenterCircleWithPaddings

        if (isPointBetweenCircles) return null // between center button and outer buttons
        if (onCenterButton) return DialPadButton.Center

        val slope = size.height.toFloat() / size.width
        val isBetweenButtonsOne =
            (slope * newOffset.x - newOffset.y).absoluteValue / sqrt(slope.pow(2) + 1) < paddingPx / 4
        val isBetweenButtonsTwo =
            (-slope * newOffset.x - newOffset.y).absoluteValue / sqrt(slope.pow(2) + 1) < paddingPx / 4

        if (isBetweenButtonsOne || isBetweenButtonsTwo) return null

        // TODO Return a DialPadButton based on the coordinates and the slope
        return DialPadButton.Top
    }
}

enum class DialPadButton {
    Top,
    Start,
    End,
    Bottom,
    Center,
}

object DialPadDefaults {

    val minWidth: Dp = 64.dp

    val minHeight: Dp = 64.dp

    val swipePadShape = RoundedCornerShape(8.dp)
}
