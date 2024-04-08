package com.chipmunksmedia.helldivers.remote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.DefaultAppComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = defaultComponentContext()

        enableEdgeToEdge()

        setContent {
            AppContent(component = appComponent(context))
        }
    }

    private fun appComponent(componentContext: ComponentContext): AppComponent = DefaultAppComponent(
        componentContext = componentContext,
        storeFactory = DefaultStoreFactory(),
    )
}
