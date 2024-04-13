package com.malliaridis.tui.domain.stratagems

import com.malliaridis.tui.model.Direction
import com.malliaridis.tui.model.Stratagem
import kotlinx.coroutines.flow.StateFlow

/**
 * The stratagem list component manages a list of stratagems available to the helldiver, as well as the current state of
 * each stratagem.
 *
 * Note that it is not responsible for calling in stratagems.
 */
interface StratagemListComponent {

    val models: StateFlow<Model>

    fun onReloadStratagems()

    /**
     * Data model that represents the state of the [StratagemListComponent].
     *
     * @property stratagems A list of stratagems that may be filtered on direction input.
     * @property filterLength The current filter length that is applied to the list.
     * @property isListAvailable Whether the stratagem list is available. May be `false` in case of e.g. an environment
     * hazard.
     * @property isLoading Whether the stratagems are being loaded.
     */
    data class Model(
        val stratagems: List<Stratagem> = emptyList(),
        val filterLength: Int = 0,
        val isListAvailable: Boolean = true,
        val isLoading: Boolean = false,
    )

    sealed interface Input {

        /**
         * Directional input for retrieving directions from outside the component.
         *
         * @property direction The direction input to handle.
         */
        data class DirectionInput(val direction: Direction) : Input
    }
}
