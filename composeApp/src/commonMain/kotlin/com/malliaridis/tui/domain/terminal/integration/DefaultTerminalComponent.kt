package com.malliaridis.tui.domain.terminal.integration

import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.terminal.TerminalComponent
import com.malliaridis.tui.domain.terminal.TerminalComponent.Model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultTerminalComponent(
    componentContext: AppComponentContext,
) : TerminalComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(Model())
}