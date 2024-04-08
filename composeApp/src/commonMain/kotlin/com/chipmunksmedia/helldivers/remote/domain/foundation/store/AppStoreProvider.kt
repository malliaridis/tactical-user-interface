package com.chipmunksmedia.helldivers.remote.domain.foundation.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore.Intent
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore.State
import com.chipmunksmedia.helldivers.remote.model.AppTab
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal class AppStoreProvider(
    private val storeFactory: StoreFactory,
    private val mainContext: CoroutineContext = Dispatchers.Main,
) {

    fun provide(): AppStore = object :
        AppStore,
        Store<Intent, State, Nothing> by storeFactory.create(
            name = "AppStore",
            initialState = State(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl,
        ) {}

    private inner class ExecutorImpl : CoroutineExecutor<Intent, Nothing, State, Message, Nothing>(mainContext) {

        override fun executeIntent(intent: Intent) = when (intent) {
            is Intent.SwitchTab -> dispatch(Message.TabSwitched(tab = intent.tab))
        }
    }

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State = when (msg) {
            is Message.TabSwitched -> copy(currentTab = msg.tab)
        }
    }

    sealed interface Message {

        /**
         * Sent when the current active tab changes.
         *
         * @property tab The tab to which was successfully switched.
         */
        data class TabSwitched(val tab: AppTab) : Message
    }
}
