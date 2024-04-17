package com.malliaridis.tui.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.ui.theme.CustomColors
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import tacticaluserinterface.composeapp.generated.resources.Res
import tacticaluserinterface.composeapp.generated.resources.super_earth_logo_with_stars

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppContainer(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    content: @Composable () -> Unit,
) {
    val primaryBackgroundColor by animateColorAsState(
        targetValue = if (isError) CustomColors.backgroundColorPrimaryError else CustomColors.backgroundColorPrimary
    )
    val secondaryBackgroundColor by animateColorAsState(
        targetValue = if (isError) CustomColors.backgroundColorSecondaryError else CustomColors.backgroundColorSecondary
    )

    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    0f to primaryBackgroundColor,
                    0.5f to secondaryBackgroundColor,
                    1f to primaryBackgroundColor,
                    start = Offset.Zero,
                    end = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
                )
            )
            .safeContentPadding(),
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(256.dp)
                .alpha(.1f),
            painter = painterResource(Res.drawable.super_earth_logo_with_stars),
            contentDescription = "Super Earth Logo",
        )
        content()
    }
}
