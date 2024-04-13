package com.malliaridis.tui.ui.components.transmissions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.malliaridis.tui.domain.transmissions.TransmissionListComponent

@Composable
fun TransmissionListContent(
    component: TransmissionListComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.models.collectAsState()

    TransmissionsList(
        modifier = modifier,
        transmissions = model.transmissions,
        onSelectTransmission = component::onSelectTransmission,
        selectedTransmissionId = model.selectedTransmissionId,
    )
}
