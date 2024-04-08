package com.chipmunksmedia.helldivers.remote.domain.foundation

import com.chipmunksmedia.helldivers.remote.model.AppTab
import kotlinx.coroutines.flow.StateFlow

interface AppComponent {

    val models: StateFlow<Model>

    /**
     * Function for when the user wants to switch the app tab.
     *
     * @param tab The tab the user wants to switch to.
     */
    fun onSwitchTab(tab: AppTab)

    data class Model(
        val currentTab: AppTab = AppTab.Stratagems,
    )
}
