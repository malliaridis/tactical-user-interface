package com.chipmunksmedia.helldivers.remote.ui.components.stratagems

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent

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
