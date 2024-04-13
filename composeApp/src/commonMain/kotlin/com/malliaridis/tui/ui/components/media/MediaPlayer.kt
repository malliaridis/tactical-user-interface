package com.malliaridis.tui.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.malliaridis.tui.ui.components.media.MediaPlayerState.Companion.Saver
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Progress values of a media player.
 *
 * @property fraction Current progress as a fraction value (between 0 and 1).
 * @property time Current progress of the player.
 * @property buffered Current buffered progress of the player.
 */
data class Progress(
    val fraction: Float,
    val time: Duration,
    val buffered: Duration,
)

/**
 * @param seek Seek time to which the player should skip (once).
 * @param speed Playback speed of the player.
 * @param volume Volume in percentage.
 * @param isResumed Whether the player is resumed or paused / stopped.
 * @param isBuffering Whether the player is buffering ([isResumed] may also be `true`).
 * @param progress The current progress of the player.
 */
class MediaPlayerState(
    seek: Float = 0f,
    speed: Float = 1f,
    volume: Float = 1f,
    isResumed: Boolean = true,
    isBuffering: Boolean = false,
    progress: Progress,
) {

    /**
     * Seek time to which the player should skip.
     */
    var seek by mutableStateOf(seek)

    /**
     * Playback speed of the player.
     */
    var speed by mutableStateOf(speed)

    /**
     * Volume in percentage.
     */
    var volume by mutableStateOf(volume)

    /**
     * Whether the player is resumed or paused / stopped.
     */
    var isResumed by mutableStateOf(isResumed)

    internal var _isBuffering = mutableStateOf(isBuffering)

    /**
     * Whether the player is buffering ([isResumed] may also be `true`).
     */
    var isBuffering: State<Boolean> = _isBuffering

    internal var _progress = mutableStateOf(progress)

    /**
     * The current progress of the player.
     */
    var progress: State<Progress> = _progress

    fun toggleResume() {
        isResumed = !isResumed
    }

    fun stopPlayback() {
        isResumed = false
    }

    fun startPlayback() {
        isResumed = true
    }

    companion object {

        /**
         * The default [Saver] implementation for [MediaPlayerState].
         */
        fun Saver() = listSaver<MediaPlayerState, Any>(
            save = {
                listOf(
                    it.seek,
                    it.speed,
                    it.volume,
                    it.isResumed,
                    it.isBuffering.value,
                    it.progress.value.fraction,
                    it.progress.value.time.inWholeMilliseconds,
                    it.progress.value.buffered.inWholeMilliseconds,
                )
            },
            restore = {
                MediaPlayerState(
                    seek = it[0] as Float,
                    speed = it[1] as Float,
                    volume = it[2] as Float,
                    isResumed = it[4] as Boolean,
                    isBuffering = it[5] as Boolean,
                    progress = Progress(
                        fraction = (it[6] as Float),
                        time = (it[7] as Long).toDuration(DurationUnit.MILLISECONDS),
                        buffered = (it[8] as Long).toDuration(DurationUnit.MILLISECONDS),
                    ),
                )
            }
        )
    }
}

@Composable
fun rememberMediaPlayerState(
    seek: Float = 0f,
    speed: Float = 1f,
    volume: Float = 1f,
    isResumed: Boolean = true,
    isFullscreen: Boolean = false
): MediaPlayerState = rememberSaveable(saver = Saver()) {
    MediaPlayerState(
        seek = seek,
        speed = speed,
        volume = volume,
        isResumed = isResumed,
        isBuffering = isFullscreen,
        progress = Progress(0f, Duration.ZERO, Duration.ZERO),
    )
}
