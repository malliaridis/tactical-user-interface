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
import platform.AVFoundation.AVPlayerItem.Companion.playerItemWithURL
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.AVPlayerStatusUnknown
import platform.AVFoundation.addPeriodicTimeObserverForInterval
import platform.AVFoundation.currentItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.removeTimeObserver
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.AVFoundation.seekToTime
import platform.AVFoundation.volume
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.CoreMedia.CMTimeMake
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
internal actual fun VideoPlayerImpl(
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
) {
    val player = remember { AVPlayer() }
    LaunchedEffect(url) {
        player.replaceCurrentItemWithPlayerItem(playerItemWithURL(URL = NSURL.URLWithString(url)!!))
    }
    val playerLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }

    avPlayerViewController.player = player
    // Disable playback controls and use custom controls instead
    avPlayerViewController.showsPlaybackControls = false

    playerLayer.player = player

    player.emitProgressTo(progressState)

    LaunchedEffect(player.currentItem?.status) {
        // TODO Add actual key-path observer to player (see https://stackoverflow.com/a/38867386)
        isBuffering.value = player.currentItem?.status == AVPlayerStatusUnknown
    }

    // Update player
    LaunchedEffect(seek) { player.seekToTime(CMTimeMake((seek * 1000).toLong(), 1000)) }
    LaunchedEffect(speed) { player.rate = speed }
    LaunchedEffect(volume) { player.volume = volume }
    LaunchedEffect(isResumed) { if (!isResumed) player.pause() else player.play() }

    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            // Return the playerContainer as the root UIView
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playerLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = {
            player.play()
            avPlayerViewController.player!!.play()
        },
        modifier = modifier,
    )

    DisposableEffect(Unit) {
        onDispose {
            // player.removeTimeObserver(???)
            player.replaceCurrentItemWithPlayerItem(null)
        }
    }
}
