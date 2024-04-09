package com.chipmunksmedia.helldivers.remote.ui.components.status

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chipmunksmedia.helldivers.remote.domain.common.SystemStateComponent

@Composable
fun StatusBarContent(
    component: SystemStateComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.models.collectAsState()

    StatusBar(
        modifier = modifier,
        status = model.currentState,
        isError = model.isCritical,
    )
}
