package com.chipmunksmedia.helldivers.remote.domain.foundation

import com.chipmunksmedia.helldivers.remote.domain.foundation.DirectionalInputComponent.Output
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadStyle
import kotlinx.coroutines.flow.StateFlow

/**
 * The directional input component is used for generating direction outputs that may be used in other components or
 * sent to the SES API.
 *
 * The interface does not have a state and therefore any implementation should use [Output] to send the outputs to
 * parents for further processing.
 */
interface DirectionalInputComponent {

    val models: StateFlow<Model>

    /**
     * Function for handling direction input.
     *
     * @param direction The direction the user inserted.
     */
    fun onDirectionInput(direction: Direction)

    data class Model(
        val style: DialPadStyle = DialPadStyle.SwipePad,
    )

    sealed interface Output {

        /**
         * Directional output that can be used to pass directions to other components.
         *
         * @property direction The direction to forward.
         */
        data class DirectionOutput(val direction: Direction) : Output
    }
}
