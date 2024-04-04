package com.chipmunksmedia.helldivers.remote.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors

/**
 * A simple striped surface that can be used for styling the components.
 */
@Composable
fun StripedSurface(
    modifier: Modifier = Modifier,
    stripeWidth: Dp = 2.dp,
    stripeToGapRatio: Float = 0.7f,
    stripeDirection: StripeDirection = StripeDirection.Up,
    color: Color = CustomColors.stripesColor,
) = Box(
    modifier = modifier
        .defaultMinSize(minWidth = 4.dp, minHeight = 4.dp)
        .background(
            brush = createStripeBrush(
                stripeWidth = stripeWidth,
                stripeDirection = stripeDirection,
                stripeToGapRatio = stripeToGapRatio,
                color = color,
            )
        ),
)

enum class StripeDirection {
    Up,
    Down,
}

/**
 * Creates a brush that can be used to apply a stripes pattern to a surface.
 *
 * @param stripeWidth The width of the stripe
 * @param stripeToGapRatio The stripe-to-gap ratio
 * @param stripeDirection In which direction the stripes should go.
 * @param color The color of the primary stripes.
 * @param secondaryColor The color of the gap to apply. Default is transparent.
 */
@Composable
fun createStripeBrush(
    stripeWidth: Dp = 4.dp,
    stripeToGapRatio: Float = 1f,
    stripeDirection: StripeDirection = StripeDirection.Up,
    color: Color = Color.Unspecified,
    secondaryColor: Color = Color.Transparent,
): Brush {
    val stripeWidthPx = LocalDensity.current.run { stripeWidth.toPx() }
    val stripeGapWidthPx = stripeWidthPx / stripeToGapRatio
    val brushSizePx = stripeGapWidthPx + stripeWidthPx
    val stripeStart = stripeGapWidthPx / brushSizePx

    val startY = when (stripeDirection) {
        StripeDirection.Up -> 0f
        StripeDirection.Down -> brushSizePx
    }
    val endY = when (stripeDirection) {
        StripeDirection.Up -> brushSizePx
        StripeDirection.Down -> 0f
    }
    return Brush.linearGradient(
        stripeStart to secondaryColor,
        stripeStart to color,
        start = Offset(0f, startY),
        end = Offset(brushSizePx, endY),
        tileMode = TileMode.Repeated,
    )
}
