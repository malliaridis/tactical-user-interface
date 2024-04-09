package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.PageComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.DefaultDirectionalInputComponent
import com.chipmunksmedia.helldivers.remote.domain.stratagems.StratagemListComponent
import com.chipmunksmedia.helldivers.remote.domain.stratagems.integration.DefaultStratagemListComponent

class StratagemsPageComponent(
    componentContext: AppComponentContext,
) : PageComponent, AppComponentContext by componentContext {

    val stratagemListComponent: StratagemListComponent = DefaultStratagemListComponent(
        componentContext = childContext("StratagemListComponent"),
    )

    val inputComponent: DirectionalInputComponent = DefaultDirectionalInputComponent(
        componentContext = childContext("DirectionalInputComponent"),
        output = {}, // TODO Handle direction outputs
    )
}
