package com.malliaridis.tui.ui.components.stratagems

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.malliaridis.tui.domain.foundation.DirectionalInputComponent

@Composable
fun DialPadContent(
    component: DirectionalInputComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.models.collectAsState()

    DialPadInput(
        modifier = modifier,
        style = model.style,
        onDirectionInput = component::onDirectionInput,
    )
}
