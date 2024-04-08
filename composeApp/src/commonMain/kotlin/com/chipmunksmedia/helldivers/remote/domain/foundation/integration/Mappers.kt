package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.store.AppStore

internal val stateToModel: (AppStore.State) -> AppComponent.Model = {
    AppComponent.Model(
        currentTab = it.currentTab,
    )
}
