package com.chipmunksmedia.helldivers.remote.domain.foundation

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.chipmunksmedia.helldivers.remote.domain.common.SystemStateComponent
import com.chipmunksmedia.helldivers.remote.domain.configuration.PreferencesComponent
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

interface AppComponent {

    @OptIn(ExperimentalDecomposeApi::class)
    val pages: StateFlow<ChildPages<Config, PageComponent>>

    val preferencesComponent: PreferencesComponent

    val systemStateComponent: SystemStateComponent

    /**
     * Function that allows switching pages.
     *
     * @param pageIndex The index of the page to switch to.
     */
    fun onSwitchPage(pageIndex: Int)

    @Serializable
    sealed interface Config {

        @Serializable
        data object Stratagems : Config

        @Serializable
        data object Terminal : Config

        @Serializable
        data object Transmissions : Config

        @Serializable
        data object Preferences : Config
    }
}
