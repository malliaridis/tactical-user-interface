package com.chipmunksmedia.helldivers.remote.ui.components.stratagems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator

@Composable
fun DialPadInput(
    modifier: Modifier = Modifier,
    style: DialPadStyle = DialPadStyle.SwipePad,
    onDirectionInput: (Direction) -> Unit,
) = StripesDecorator(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    rtl = true,
) {
    DialPad(
        modifier = Modifier
            .alpha(.7f)
            .weight(1f)
            .aspectRatio(1f),
        style = style,
        onDirectionDetect = onDirectionInput,
    )
}
