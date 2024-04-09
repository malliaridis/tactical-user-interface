package com.chipmunksmedia.helldivers.remote.domain.foundation.store

import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent.Model
import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent.Output
import com.chipmunksmedia.helldivers.remote.model.Direction
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
