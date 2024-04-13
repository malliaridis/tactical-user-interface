package com.malliaridis.tui.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun VideoPlayer(
    url: String,
    state: MediaPlayerState,
    isFullScreen: Boolean,
    modifier: Modifier = Modifier,
    onFinish: (() -> Unit)? = null,
) = VideoPlayerImpl(
    url = url,
    isResumed = state.isResumed,
    volume = state.volume,
    speed = state.speed,
    seek = state.seek,
    isFullscreen = isFullScreen,
    isBuffering = state._isBuffering,
    progressState = state._progress,
    modifier = modifier,
    onFinish = onFinish,
)

@Composable
internal expect fun VideoPlayerImpl(
    url: String,
    isResumed: Boolean,
    volume: Float,
    speed: Float,
    seek: Float,
    isFullscreen: Boolean,
    isBuffering: MutableState<Boolean>,
    progressState: MutableState<Progress>,
    modifier: Modifier,
    onFinish: (() -> Unit)?,
)
