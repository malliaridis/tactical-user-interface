package com.chipmunksmedia.helldivers.remote.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.media3.common.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Checks for and emits video progress every [delayMs] milliseconds (defaults to 250ms).
 */
@Composable
internal fun Player.emitProgressTo(
    state: MutableState<Progress>,
    delayMs: Long = 250,
) {
    LaunchedEffect(key1 = Unit) {
        while (isActive) {
            state.value = Progress(
                fraction = currentPosition.toFloat() / duration,
                time = currentPosition.toDuration(DurationUnit.MILLISECONDS),
                buffered = bufferedPosition.toDuration(DurationUnit.MILLISECONDS),
            )

            delay(delayMs)
        }
    }
}
