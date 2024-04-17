package com.malliaridis.tui

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.malliaridis.tui.domain.foundation.DefaultAppComponentContext
import com.malliaridis.tui.domain.foundation.integration.DefaultAppComponent

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    // Always create the app component outside Compose on the UI thread
    val appComponent =
        runOnUiThread {
            DefaultAppComponent(
                componentContext = DefaultAppComponentContext(
                    componentContext = DefaultComponentContext(lifecycle = lifecycle),
                ),
                storeFactory = DefaultStoreFactory(),
            )
        }

    application {
        val windowState = rememberWindowState()

        LifecycleController(lifecycle, windowState)

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Tactical User Interface",
        ) {
            App(appComponent = appComponent)
        }
    }
}
