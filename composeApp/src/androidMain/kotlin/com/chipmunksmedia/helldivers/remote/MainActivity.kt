package com.chipmunksmedia.helldivers.remote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.DefaultAppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.DefaultAppComponent

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
