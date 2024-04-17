package com.malliaridis.tui.domain.common

import kotlinx.coroutines.flow.StateFlow

/**
 * The systems state component manages a global state of all systems. It merges multiple states together, including the
 * SES connection state and environment changes like hazards.
 *
 * The systems state can be used to update the appearance of the app or show the current state as a status bar.
 */
interface SystemStateComponent {

    val models: StateFlow<Model>

    /**
     * Data class that represents the state of [SystemStateComponent].
     *
     * @property currentState The current state shown as text.
     * @property isCritical Whether the current state is critical.
     */
    data class Model(
        val currentState: String = "",
        val isCritical: Boolean = false,
    )
}
