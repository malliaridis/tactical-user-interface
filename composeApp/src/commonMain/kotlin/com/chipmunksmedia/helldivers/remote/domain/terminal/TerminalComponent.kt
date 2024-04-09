package com.chipmunksmedia.helldivers.remote.domain.terminal

import kotlinx.coroutines.flow.StateFlow

/**
 * The terminal component is the command prompt provided to the user for looking up the event history.
 *
 * To follow the SOLID principles, this component does not support command execution as one would expect from a
 * "terminal" / user prompt component. Individual actions (like for connection management) are handled by the according
 * components.
 */
interface TerminalComponent {

    /**
     * The state flow of this component holding the latest state of this component.
     */
    val models: StateFlow<Model>

    /**
     * Data model that represents the [TerminalComponent]'s state.
     *
     * @property events Event history
     *
     * TODO See if the events can be the messages published by individual stores
     */
    data class Model(
        val events: List<Any> = emptyList(),
    )
}
