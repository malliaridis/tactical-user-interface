package com.chipmunksmedia.helldivers.remote.domain.foundation.integration

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.chipmunksmedia.helldivers.remote.domain.common.SystemStateComponent
import com.chipmunksmedia.helldivers.remote.domain.common.integration.DefaultSystemsStateComponent
import com.chipmunksmedia.helldivers.remote.domain.configuration.integration.DefaultPreferencesComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent.Config
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponentContext
import com.chipmunksmedia.helldivers.remote.domain.foundation.PageComponent
import com.chipmunksmedia.helldivers.remote.domain.utils.toStateFlow
import com.chipmunksmedia.helldivers.remote.model.PreferenceCollectionKeys
import kotlinx.coroutines.flow.StateFlow

class DefaultAppComponent(
    componentContext: AppComponentContext,
    storeFactory: StoreFactory,
) : AppComponent, AppComponentContext by componentContext {

    override val preferencesComponent = DefaultPreferencesComponent(
        componentContext = childContext("PreferencesComponent"),
        collectionKey = PreferenceCollectionKeys.PCK_SETTINGS,
    )

    override val systemStateComponent: SystemStateComponent = DefaultSystemsStateComponent(
        componentContext = childContext("SystemStateComponent"),
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private val navigation = PagesNavigation<Config>()

    @OptIn(ExperimentalDecomposeApi::class)
    override val pages: StateFlow<ChildPages<Config, PageComponent>> = childPages(
        source = navigation,
        initialPages = {
            Pages(
                items = listOf(
                    Config.Stratagems,
                    Config.Terminal,
                    Config.Transmissions,
                    Config.Preferences,
                ),
                selectedIndex = 0,
            )
        },
        serializer = Config.serializer(),
        handleBackButton = false,
        childFactory = ::createChild,
    ).toStateFlow()

    @OptIn(ExperimentalDecomposeApi::class)
    override fun onSwitchPage(pageIndex: Int) = navigation.select(pageIndex)

    private fun createChild(
        config: Config,
        childComponentContext: AppComponentContext,
    ): PageComponent = when (config) {
        is Config.Stratagems -> StratagemsPageComponent(
            componentContext = childComponentContext,
        )

        is Config.Terminal -> TerminalPageComponent(
            componentContext = childComponentContext,
        )

        is Config.Transmissions -> TransmissionsPageComponent(
            componentContext = childComponentContext,
        )

        is Config.Preferences -> PreferencesPageComponent(
            componentContext = childComponentContext,
        )
    }
}
