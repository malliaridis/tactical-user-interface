package com.malliaridis.tui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.malliaridis.tui.domain.foundation.AppComponent
import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.foundation.DefaultAppComponentContext
import com.malliaridis.tui.domain.foundation.integration.DefaultAppComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val componentContext = DefaultAppComponentContext(
            componentContext = defaultComponentContext(),
        )
        enableEdgeToEdge()

        setContent {
            App(
                appComponent = appComponent(componentContext),
            )
        }
    }

    private fun appComponent(componentContext: AppComponentContext): AppComponent = DefaultAppComponent(
        componentContext = componentContext,
        storeFactory = DefaultStoreFactory(),
    )
}
