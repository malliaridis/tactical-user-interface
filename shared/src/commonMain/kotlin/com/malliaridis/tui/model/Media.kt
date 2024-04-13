package com.malliaridis.tui.model

sealed interface Media {

    val id: String

    val uri: String

    val description: String

    val type: MediaType

    data class VideoMedia(
        override val id: String,
        override val uri: String,
        val thumbnail: String?,
        override val description: String,
    ) : Media {
        override val type: MediaType = MediaType.Video
    }

    data class AudioMedia(
        override val id: String,
        override val uri: String,
        override val description: String,
        val amplitude: List<Float>?,
    ) : Media {
        override val type: MediaType = MediaType.Audio
    }

    data class ImageMedia(
        override val id: String,
        override val uri: String,
        override val description: String,
    ) : Media {
        override val type: MediaType = MediaType.Image
    }
}

enum class MediaType {
    Audio,
    Image,
    Video,
}
