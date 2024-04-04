package com.chipmunksmedia.helldivers.remote.ui.components.terminal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.components.ActionButton
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator

@Composable
fun TerminalActions(
    modifier: Modifier = Modifier,
) = StripesDecorator(
    modifier = modifier.height(IntrinsicSize.Max),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Check SES Connection",
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Reconnect with SES",
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Disconnect from SES",
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Reboot Systems",
        )
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Shutdown Systems",
        )
    }
}
