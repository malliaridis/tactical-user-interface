package com.malliaridis.tui.domain.foundation.store

import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.foundation.DirectionalInputComponent
import com.malliaridis.tui.domain.foundation.DirectionalInputComponent.Model
import com.malliaridis.tui.domain.foundation.DirectionalInputComponent.Output
import com.malliaridis.tui.model.Direction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultDirectionalInputComponent(
    componentContext: AppComponentContext,
    private val output: (Output) -> Unit,
) : DirectionalInputComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(Model())

    override fun onDirectionInput(direction: Direction) = output(Output.DirectionOutput(direction))
}
