package com.chipmunksmedia.helldivers.remote.domain.foundation.store

import com.arkivanov.mvikotlin.core.store.Store
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore.Intent
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore.State
import com.chipmunksmedia.helldivers.remote.model.AppTab

/**
 * Store used for state preservation of the [com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent].
 */
interface AppStore : Store<Intent, State, Nothing> {

    sealed interface Intent {
        data class SwitchTab(val tab: AppTab) : Intent
    }

    data class State(
        val currentTab: AppTab = AppTab.Stratagems,
    )
}
