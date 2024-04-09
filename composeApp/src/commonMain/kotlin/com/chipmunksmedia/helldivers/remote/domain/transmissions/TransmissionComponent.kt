package com.chipmunksmedia.helldivers.remote.domain.transmissions

import com.chipmunksmedia.helldivers.remote.model.TransmissionDetails
import kotlinx.coroutines.flow.StateFlow

/**
 * The transmission component loads the details of a single transmission and may include [MediaComponent] in case the
 * transmission includes media.
 */
interface TransmissionComponent {

    val models: StateFlow<Model>

    /**
     * Model that represents the state of [TransmissionComponent].
     *
     * @property transmissionId The ID of transmission loaded by this component.
     * @property isLoading Whether the details are being loaded.
     * @property transmission The details of the transmission with the ID [transmissionId].
     */
    data class Model(
        val transmissionId: String,
        val isLoading: Boolean = false,
        val transmission: TransmissionDetails? = null,
    )
}
