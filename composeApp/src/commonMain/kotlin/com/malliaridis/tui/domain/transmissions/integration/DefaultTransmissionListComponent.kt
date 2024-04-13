package com.malliaridis.tui.domain.transmissions.integration

import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.transmissions.TransmissionListComponent
import com.malliaridis.tui.domain.transmissions.TransmissionListComponent.Model
import com.malliaridis.tui.domain.transmissions.TransmissionListComponent.Output
import com.malliaridis.tui.model.TransmissionListEntry
import com.malliaridis.tui.model.TransmissionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultTransmissionListComponent(
    componentContext: AppComponentContext,
    private val output: (Output) -> Unit,
) : TransmissionListComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(
        Model(transmissions = getTransmissionList())
    )

    override fun onSelectTransmission(transmissionId: String) {
        // TODO Update store state
        output(Output.TransmissionSelected(transmissionId))
    }
}

private fun getTransmissionList() = listOf(
    TransmissionListEntry(
        id = "random-id-83155",
        timestamp = 3605090400000,
        until = null,
        title = "Update: Malevelon Creek",
        type = TransmissionType.Audio,
    ),
    TransmissionListEntry(
        id = "random-id-71266",
        timestamp = 3605065200000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
    ),
    TransmissionListEntry(
        id = "random-id-65406",
        timestamp = 3605058000000,
        until = 3605317200000,
        title = "Major Order: Troost",
        type = TransmissionType.Text,
    ),
    TransmissionListEntry(
        id = "random-id-54056",
        timestamp = 3604978800000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
    ),
)
