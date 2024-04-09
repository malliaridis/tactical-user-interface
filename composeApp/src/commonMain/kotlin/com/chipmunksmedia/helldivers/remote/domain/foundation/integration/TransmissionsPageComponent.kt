package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.PageComponent
import com.chipmunksmedia.helldivers.remote.domain.transmissions.TransmissionComponent
import com.chipmunksmedia.helldivers.remote.domain.transmissions.TransmissionListComponent
import com.chipmunksmedia.helldivers.remote.domain.transmissions.integration.DefaultTransmissionListComponent

class TransmissionsPageComponent(
    componentContext: AppComponentContext,
) : PageComponent, AppComponentContext by componentContext {

    val transmissionListComponent: TransmissionListComponent = DefaultTransmissionListComponent(
        componentContext = childContext("TransmissionListComponent"),
        output = {}, // TODO Handle outputs
    )

    val transmissionComponent: TransmissionComponent? = null
}
