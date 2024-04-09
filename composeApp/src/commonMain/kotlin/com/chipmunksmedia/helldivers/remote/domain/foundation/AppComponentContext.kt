package com.chipmunksmedia.helldivers.remote.domain.foundation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ComponentContextFactory
import com.arkivanov.decompose.GenericComponentContext
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.statekeeper.StateKeeperOwner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlin.coroutines.CoroutineContext

interface AppComponentContext : GenericComponentContext<AppComponentContext>, CoroutineContextHolder

class DefaultAppComponentContext(
    componentContext: ComponentContext,
    override val mainContext: CoroutineContext = Dispatchers.Main,
    override val ioContext: CoroutineContext = Dispatchers.IO,
) : AppComponentContext,
    LifecycleOwner by componentContext,
    StateKeeperOwner by componentContext,
    InstanceKeeperOwner by componentContext,
    BackHandlerOwner by componentContext {

    constructor(componentContext: ComponentContext) : this(
        componentContext = componentContext,
        mainContext = Dispatchers.Main,
        ioContext = Dispatchers.IO,
    )

    override val componentContextFactory: ComponentContextFactory<AppComponentContext> =
        ComponentContextFactory { lifecycle, stateKeeper, instanceKeeper, backHandler ->
            val ctx = componentContext.componentContextFactory(lifecycle, stateKeeper, instanceKeeper, backHandler)
            DefaultAppComponentContext(ctx, mainContext, ioContext)
        }
}
