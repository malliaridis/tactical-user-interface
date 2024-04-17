package com.malliaridis.tui.ui.components.transmissions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.model.TransmissionListEntry
import com.malliaridis.tui.ui.theme.CustomColors
import com.malliaridis.tui.ui.theme.Modifiers.border
import com.malliaridis.tui.ui.utils.toSubtitle

@Composable
fun TransmissionListItem(
    modifier: Modifier = Modifier,
    transmission: TransmissionListEntry,
    isSelected: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
) {
    val isPressed by interactionSource.collectIsPressedAsState()

    Row(
        modifier = modifier
            .background(
                if (isPressed) CustomColors.seedColor.copy(alpha = 0.5f)
                else CustomColors.buttonBackgroundColor,
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .border(
                left = if (isSelected || isPressed) 2.dp else 0.dp,
                color = CustomColors.seedColor,
            )
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = transmission.title,
                style = MaterialTheme.typography.titleMedium,
                color = CustomColors.textColor,
            )
            Text(
                text = transmission.type.toSubtitle(),
                style = MaterialTheme.typography.bodyMedium,
                color = CustomColors.textColorVariant,
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
        ) {}
    }
}