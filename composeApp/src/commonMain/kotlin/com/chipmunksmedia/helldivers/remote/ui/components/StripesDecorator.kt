package com.chipmunksmedia.helldivers.remote.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.border

@Composable
fun StripesDecorator(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    rtl: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) = Row(
    modifier = modifier,
    horizontalArrangement = horizontalArrangement,
    verticalAlignment = verticalAlignment,
) {

    if (rtl) content()
    StripedSurface(
        modifier = Modifier
            .width(16.dp)
            .fillMaxHeight()
            .border(
                left = if (!rtl) 1.5.dp else 0.dp,
                top = 1.5.dp,
                bottom = 1.5.dp,
                right = if (rtl) 1.5.dp else 0.dp,
                color = CustomColors.borderColorVariant,
            )
            .padding(4.dp),
    )
    if (!rtl) content()
}
