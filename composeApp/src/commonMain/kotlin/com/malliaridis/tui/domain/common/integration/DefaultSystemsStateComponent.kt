package com.malliaridis.tui.domain.common.integration

import com.malliaridis.tui.domain.common.SystemStateComponent
import com.malliaridis.tui.domain.common.SystemStateComponent.Model
import com.malliaridis.tui.domain.foundation.AppComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultSystemsStateComponent(
    componentContext: AppComponentContext,
) : SystemStateComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow instantiation with store state
    override val models: StateFlow<Model> = MutableStateFlow(
        Model(currentState = "All Systems Operational")
    )
}
