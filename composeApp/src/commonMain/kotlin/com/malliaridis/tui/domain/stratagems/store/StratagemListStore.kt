package com.malliaridis.tui.domain.stratagems.store

import com.malliaridis.tui.model.Direction
import com.malliaridis.tui.model.Stratagem

interface StratagemListStore {

    sealed interface Intent {

        /**
         * Intent that updates the [State.filter] when new direction inputs are retrieved.
         *
         * @property direction The new direction to add to the filter.
         */
        data class InputDirection(val direction: Direction) : Intent
    }

    /**
     * State that represents the [StratagemListStore]'s state.
     *
     * @property stratagemList The full list of available stratagems.
     * @property filter The current stratagem filter.
     */
    data class State(
        val stratagemList: List<Stratagem>,
        val filter: List<Direction>,
    )
}
