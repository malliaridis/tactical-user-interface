package com.chipmunksmedia.helldivers.remote.domain.transmissions

import com.chipmunksmedia.helldivers.remote.model.TransmissionListEntry
import kotlinx.coroutines.flow.StateFlow

/**
 * The transmission list component loads and handles interactions with transmission list items.
 */
interface TransmissionListComponent {

    val models: StateFlow<Model>

    /**
     * Function for handling transmission selections.
     *
     * @param transmissionId The ID of the transmission that was clicked.
     */
    fun onSelectTransmission(transmissionId: String)

    data class Model(
        val transmissions: List<TransmissionListEntry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedTransmissionId: String? = null,
    )

    sealed interface Output {

        /**
         * Output that is sent whenever a transmission is selected.
         *
         * @property transmissionId The ID of the transmission that was selected.
         */
        data class TransmissionSelected(val transmissionId: String) : Output
    }
}
