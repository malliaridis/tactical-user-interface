package com.chipmunksmedia.helldivers.remote.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.AVPlayerStatusUnknown
import platform.AVFoundation.currentItem
import platform.AVFoundation.duration
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.AVFoundation.seekToTime
import platform.AVFoundation.volume
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.CoreMedia.CMTimeGetSeconds
import platform.CoreMedia.CMTimeMake
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
internal actual fun AudioPlayerImpl(
    url: String,
    isResumed: Boolean,
    volume: Float,
    speed: Float,
    seek: Float,
    isBuffering: MutableState<Boolean>,
    progressState: MutableState<Progress>,
    modifier: Modifier,
    onFinish: (() -> Unit)?,
) {
    val player = remember { AVPlayer() }
    LaunchedEffect(url) {
        player.replaceCurrentItemWithPlayerItem(AVPlayerItem.playerItemWithURL(URL = NSURL.URLWithString(url)!!))
    }

    player.emitProgressTo(progressState)

    LaunchedEffect(player.currentItem?.status) {
        // TODO Add actual key-path observer to player (see https://stackoverflow.com/a/38867386)
        isBuffering.value = player.currentItem?.status == AVPlayerStatusUnknown
    }

    // Update player
    LaunchedEffect(seek) {
        val seekTimeMs = (CMTimeGetSeconds(player.currentItem!!.duration) * seek * 1000).toLong()
        player.seekToTime(CMTimeMake(seekTimeMs, 1000))
    }
    LaunchedEffect(speed) { player.rate = speed }
    LaunchedEffect(volume) { player.volume = volume }
    LaunchedEffect(isResumed) { if (!isResumed) player.pause() else player.play() }

    DisposableEffect(Unit) {
        onDispose {
            player.replaceCurrentItemWithPlayerItem(null)
        }
    }
}
