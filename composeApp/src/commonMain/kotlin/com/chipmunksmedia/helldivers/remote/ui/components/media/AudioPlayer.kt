package com.chipmunksmedia.helldivers.remote.ui.components.media

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Media
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import helldiversremote.composeapp.generated.resources.Res
import helldiversremote.composeapp.generated.resources.ic_pause
import helldiversremote.composeapp.generated.resources.ic_play
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AudioPlayer(
    audio: Media.AudioMedia,
    state: MediaPlayerState,
    modifier: Modifier = Modifier,
    onFinish: (() -> Unit)? = null,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    IconButton(
        modifier = Modifier.size(56.dp).padding(8.dp),
        onClick = { state.toggleResume() }
    ) {
        if (state.isResumed) Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.ic_pause),
            tint = CustomColors.textColor,
            contentDescription = "pause icon",
        )
        else Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.ic_play),
            tint = CustomColors.textColor,
            contentDescription = "play icon",
        )
    }

    val updatedState by rememberUpdatedState(state)
    val progress by updatedState.progress

    var seekPosition by remember { mutableStateOf(0f) }
    var isDragging by remember { mutableStateOf(false) }

    val amplitude = audio.amplitude
    if (amplitude == null) Slider(
        modifier = Modifier.fillMaxWidth(),
        value = seekPosition,
        onValueChange = {
            isDragging = true
            seekPosition = it
        },
        onValueChangeFinished = {
            isDragging = false
            updatedState.seek = seekPosition
        },
    ) else AudioVisualizer(
        value = seekPosition,
        amplitudes = amplitude,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {
            isDragging = true
            seekPosition = it
        },
        onValueChangeFinished = {
            isDragging = false
            updatedState.seek = seekPosition
        }
    )

    LaunchedEffect(progress) {
        if (!isDragging) seekPosition = progress.fraction
    }

    AudioPlayerImpl(
        url = audio.uri,
        isResumed = state.isResumed,
        volume = state.volume,
        speed = state.speed,
        seek = state.seek,
        isBuffering = state._isBuffering,
        progressState = state._progress,
        modifier = modifier,
        onFinish = onFinish,
    )
}

@Composable
internal expect fun AudioPlayerImpl(
    url: String,
    isResumed: Boolean,
    volume: Float,
    speed: Float,
    seek: Float,
    isBuffering: MutableState<Boolean>,
    progressState: MutableState<Progress>,
    modifier: Modifier,
    onFinish: (() -> Unit)?,
)
