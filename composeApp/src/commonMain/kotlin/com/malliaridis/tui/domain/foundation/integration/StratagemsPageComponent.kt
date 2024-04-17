package com.malliaridis.tui.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.foundation.DirectionalInputComponent
import com.malliaridis.tui.domain.foundation.PageComponent
import com.malliaridis.tui.domain.foundation.store.DefaultDirectionalInputComponent
import com.malliaridis.tui.domain.stratagems.StratagemListComponent
import com.malliaridis.tui.domain.stratagems.integration.DefaultStratagemListComponent

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
