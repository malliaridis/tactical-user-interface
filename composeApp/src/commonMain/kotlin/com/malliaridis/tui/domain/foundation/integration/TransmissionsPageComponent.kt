package com.malliaridis.tui.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.foundation.PageComponent
import com.malliaridis.tui.domain.transmissions.TransmissionComponent
import com.malliaridis.tui.domain.transmissions.TransmissionListComponent
import com.malliaridis.tui.domain.transmissions.integration.DefaultTransmissionListComponent

class TransmissionsPageComponent(
    componentContext: AppComponentContext,
) : PageComponent, AppComponentContext by componentContext {

    val transmissionListComponent: TransmissionListComponent = DefaultTransmissionListComponent(
        componentContext = childContext("TransmissionListComponent"),
        output = {}, // TODO Handle outputs
    )

    val transmissionComponent: TransmissionComponent? = null
}
