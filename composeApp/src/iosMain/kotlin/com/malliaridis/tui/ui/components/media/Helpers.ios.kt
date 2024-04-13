package com.malliaridis.tui.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import com.malliaridis.tui.ui.components.media.Progress
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.asset
import platform.AVFoundation.currentItem
import platform.AVFoundation.currentTime
import platform.CoreMedia.CMTimeGetSeconds
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Checks for and emits video progress every [delayMs] milliseconds (defaults to 250ms).
 */
@OptIn(ExperimentalForeignApi::class)
@Composable
internal fun AVPlayer.emitProgressTo(
    state: MutableState<Progress>,
    delayMs: Long = 250,
) {
    LaunchedEffect(Unit) {
        // Using AVPlayer.addPeriodicTimeObserverForInterval() may cause tracks
        // to jump back and forth when seeking new time, so we use a custom observer
        while (isActive) {
            val duration = currentItem?.asset?.duration

            if (duration == null) {
                state.value = Progress(
                    fraction = 0f,
                    time = Duration.ZERO,
                    buffered = Duration.ZERO,
                )
            } else {
                val actualDuration = (CMTimeGetSeconds(duration) * 1000)
                val currentTime = (CMTimeGetSeconds(currentTime()) * 1000)

                state.value = Progress(
                    fraction = (currentTime / actualDuration).toFloat(),
                    time = currentTime.toDuration(DurationUnit.MILLISECONDS),
                    buffered = Duration.ZERO,
                )
            }
            delay(delayMs)
        }
    }
}
