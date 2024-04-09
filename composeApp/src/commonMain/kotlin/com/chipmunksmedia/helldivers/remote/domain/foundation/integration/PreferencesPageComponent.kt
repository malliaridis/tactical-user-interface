package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.chipmunksmedia.helldivers.remote.domain.configuration.PreferencesComponent
import com.chipmunksmedia.helldivers.remote.domain.configuration.integration.DefaultPreferencesComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.PageComponent

class PreferencesPageComponent(
    componentContext: AppComponentContext,
) : PageComponent, AppComponentContext by componentContext {

    val preferencesComponent: PreferencesComponent = DefaultPreferencesComponent(
        componentContext = childContext("PreferencesComponent"),
        collectionKey = "settings",
    )
}
