package com.malliaridis.tui.domain.foundation.integration

import com.arkivanov.decompose.childContext
import com.malliaridis.tui.domain.configuration.PreferencesComponent
import com.malliaridis.tui.domain.configuration.integration.DefaultPreferencesComponent
import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.domain.foundation.PageComponent

class PreferencesPageComponent(
    componentContext: AppComponentContext,
) : PageComponent, AppComponentContext by componentContext {

    val preferencesComponent: PreferencesComponent = DefaultPreferencesComponent(
        componentContext = childContext("PreferencesComponent"),
        collectionKey = "settings",
    )
}
