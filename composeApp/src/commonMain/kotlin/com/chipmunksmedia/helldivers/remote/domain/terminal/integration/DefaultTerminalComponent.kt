package com.chipmunksmedia.helldivers.remote.domain.terminal.integration

import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.terminal.TerminalComponent
import com.chipmunksmedia.helldivers.remote.domain.terminal.TerminalComponent.Model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultTerminalComponent(
    componentContext: AppComponentContext,
) : TerminalComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(Model())
}