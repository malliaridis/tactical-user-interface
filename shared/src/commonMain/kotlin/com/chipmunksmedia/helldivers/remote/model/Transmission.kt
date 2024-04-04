package com.chipmunksmedia.helldivers.remote.model

/**
 * A transmission list entry holds only the most relevant information.
 *
 * @property id Unique identifier of the transmission.
 * @property timestamp Timestamp of the transmission (in milliseconds, since epoch).
 * @property until Timestamp for when the transmission will end (in milliseconds, since epoch). Relevant for limited
 * time transmissions like major orders. May be `null`.
 * @property title Display title of the transmission.
 * @property type Type of the transmission.
 */
data class TransmissionListEntry(
    val id: String,
    val timestamp: Long,
    val until: Long?,
    val title: String,
    val type: TransmissionType,
)

/**
 * A transmission details object holds all the information of a transmission, including details.
 *
 * @property id Unique identifier of the transmission.
 * @property timestamp Timestamp of the transmission (in UTC milliseconds).
 * @property until Timestamp for when the transmission will end. Relevant for limited time transmissions like major
 * orders. May be `null`.
 * @property title Display title of the transmission.
 * @property type Type of the transmission.
 * @property content The content of the transmission. May be empty.
 * @property media Media data attached to the transmission.
 */
data class TransmissionDetails(
    val id: String,
    val timestamp: Long,
    val until: Long?,
    val title: String,
    val type: TransmissionType,
    val content: String,
    val media: Media?,
)

/**
 * List of transmission types.
 */
enum class TransmissionType {
    /**
     * Unknown transmission type. Used as a fallback and for unknown transmissions.
     */
    Unknown,

    /**
     * Audio transmission type. Used for audio transmissions that usually contain media of type [MediaType.Audio].
     */
    Audio,

    /**
     * Text transmission type. Used for text transmissions.
     */
    Text,

    /**
     * Video transmission type. Used for video transmissions that usually contain media of type [MediaType.Video].
     */
    Video,
}
