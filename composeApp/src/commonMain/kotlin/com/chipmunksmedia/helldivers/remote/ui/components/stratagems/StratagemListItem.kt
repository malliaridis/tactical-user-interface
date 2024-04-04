package com.chipmunksmedia.helldivers.remote.ui.components.stratagems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.utils.getDirectionDisplayName
import com.chipmunksmedia.helldivers.remote.ui.utils.getDirectionPainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * A list entry that represents a stratagem.
 *
 * @param displayName Display name of the stratagem.
 * @param drawable Icon of the stratagem.
 * @param dialCode Dial code for calling in the stratagem.
 * @param highlightCount The amount of highlighted directions in the dial code (starting from left).
 * @param modifier Modifier applied to the root composable.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun StratagemListEntry(
    displayName: String,
    drawable: DrawableResource,
    dialCode: Array<Direction>,
    highlightCount: Int = 0,
    modifier: Modifier = Modifier,
) = Row(
    modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
) {
    Image(
        modifier = Modifier.size(40.dp),
        painter = painterResource(drawable),
        contentDescription = displayName,
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = displayName,
            style = MaterialTheme.typography.titleSmall,
            color = CustomColors.textColor,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            dialCode.forEachIndexed { index, direction ->
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = getDirectionPainter(direction),
                    contentDescription = getDirectionDisplayName(direction),
                    colorFilter = ColorFilter.tint(
                        if (index < highlightCount) CustomColors.seedColor else Color.White,
                    )
                )
            }
        }
    }
}
