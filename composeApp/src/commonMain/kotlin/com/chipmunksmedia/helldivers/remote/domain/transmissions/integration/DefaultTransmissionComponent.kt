package com.chipmunksmedia.helldivers.remote.domain.transmissions.integration

import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.transmissions.TransmissionComponent
import com.chipmunksmedia.helldivers.remote.domain.transmissions.TransmissionComponent.Model
import com.chipmunksmedia.helldivers.remote.model.Media
import com.chipmunksmedia.helldivers.remote.model.TransmissionDetails
import com.chipmunksmedia.helldivers.remote.model.TransmissionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultTransmissionComponent(
    componentContext: AppComponentContext,
    transmissionId: String,
) : TransmissionComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow with store state
    override val models: StateFlow<Model> = MutableStateFlow(
        Model(
            transmissionId = transmissionId,
            transmission = getTransmissionDetailsById(transmissionId),
        )
    )
}

private fun getTransmissionDetailsById(id: String): TransmissionDetails = when (id) {
    "random-id-83155" -> TransmissionDetails(
        id = "random-id-83155",
        timestamp = 3605090400000,
        until = null,
        title = "Update: Malevelon Creek",
        type = TransmissionType.Audio,
        content = """
            “This is Sergeant Jacobson, Helldiver Unit 7, transmitting my final message before succumbing to the relentless assault of the automatons in Malevelon Creek Sector.
            We've faced a ferocity unlike anything we've encountered before. The machines are relentless, cunning, and seemingly endless in number. Our ammunition is running critically low, and our defenses have been breached. The din of battle surrounds me as I dictate these words, and I fear our position is untenable.
            To my fellow soldiers: fight on with valor and unwavering determination. Our sacrifice here today may pave the way for future victories against the mechanized scourge. Remember, the spirit of resilience that binds us as comrades shall endure, even beyond the confines of this mortal coil.
            To my family: I carry your love and memories with me into the abyss. Know that I faced this final hour with courage and resolve, in service of a cause greater than myself.
            To Command: Our situation is dire, and I fear reinforcements may arrive too late. Transmit our coordinates to any surviving units and pray that they can hold the line where we could not.
            This will be my final communication. May our efforts not be in vain.
            Sergeant Jacobson, signing off.”
        """.trimIndent(),
        media = Media.AudioMedia(
            id = "random-media-id-12937",
            uri = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3",
            description = "12937",
            amplitude = null,
            // amplitude = listOf(0.1f, 0.6f, 0.4f, 0.45f, 0.5f, 0.7f, 0.3f, 0.35f, 0.3f, 0.2f, 0.1f, 0.6f, 0.8f, 0.7f, 0.75f, 0.3f, 0.37f),
        )
    )

    "random-id-71266" -> TransmissionDetails(
        id = "random-id-71266",
        timestamp = 3605065200000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
        content = "Super Earth Daily News with Trevor Noah.",
        media = Media.VideoMedia(
            id = "random-media-id-65405",
            uri = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            thumbnail = null,
            description = "65405",
        )
    )

    "random-id-65406" -> TransmissionDetails(
        id = "random-id-65406",
        timestamp = 3605058000000,
        until = 3605317200000,
        title = "Major Order: Troost",
        type = TransmissionType.Text,
        content = """
            We have discovered Automaton plans for something called “The Reclamation”.
            Capturing their deep-space comms array on Troost may reveal critical intel about their plans.

            Order Overview:
            - Liberate Troost.
              - TROOST.
        """.trimIndent(),
        media = null,
    )

    "random-id-54056" -> TransmissionDetails(
        id = "random-id-54056",
        timestamp = 3604978800000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
        content = "Super Earth Daily News with Trevor Noah.",
        media = Media.VideoMedia(
            id = "random-media-id-28151",
            // .mov files are not supported by AVPlayer (iOS)
            uri = "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-lavf-56.36.100-aac-avc-main-1280x720.mkv",
            thumbnail = null,
            description = "28151",
        )
    )

    else -> TransmissionDetails(
        id = id,
        timestamp = 0,
        until = null,
        title = "Unknown Transmission",
        type = TransmissionType.Unknown,
        content = "Transmission could not be decoded.",
        media = null,
    )
}
