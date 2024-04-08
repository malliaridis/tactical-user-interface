package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent.Model
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore.Intent
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStoreProvider
import com.chipmunksmedia.helldivers.remote.domain.utils.coroutineScope
import com.chipmunksmedia.helldivers.remote.domain.utils.map
import com.chipmunksmedia.helldivers.remote.model.AppTab
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

class DefaultAppComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    mainContext: CoroutineContext = Dispatchers.Main,
) : AppComponent, ComponentContext by componentContext {

    private val mainScope = coroutineScope(mainContext)

    private val store: AppStore = instanceKeeper.getStore {
        AppStoreProvider(storeFactory = storeFactory).provide()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val models: StateFlow<Model> = store.stateFlow.map(mainScope, stateToModel)

    override fun onSwitchTab(tab: AppTab) = store.accept(Intent.SwitchTab(tab))
}
