package com.malliaridis.tui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.malliaridis.tui.domain.foundation.AppComponent
import com.malliaridis.tui.ui.components.AppContainer
import com.malliaridis.tui.ui.components.PageContent
import com.malliaridis.tui.ui.components.SimplifiedTabRow
import com.malliaridis.tui.ui.theme.HelldiversTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalDecomposeApi::class)
@Composable
@Preview
fun App(appComponent: AppComponent) {

    // Use dark theme as base to reduce the amount of overrides in custom UI components
    HelldiversTheme(useDarkTheme = true) {

        val pages by appComponent.pages.collectAsState()

        val preferences = appComponent.preferencesComponent

        val systemState = appComponent.systemStateComponent

        val preferenceModel by preferences.models.collectAsState()

        val systemModel by systemState.models.collectAsState()

        AppContainer(
            modifier = Modifier.fillMaxSize(),
            isError = systemModel.isCritical,
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SimplifiedTabRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .wrapContentWidth(align = Alignment.Start),
                    selectedTabIndex = pages.selectedIndex,
                    onTabClick = appComponent::onSwitchPage,
                )

                val pageComponent = pages.items[pages.selectedIndex].instance ?: return@Column

                PageContent(
                    pageComponent = pageComponent,
                    systemStateComponent = systemState,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

internal fun getTerminalOutput(): String = """
    SYSTEM: Booting Tactical User Interface version 0.1.0
    .
    .
    System booted successful
    Sending ENCRYPTED broadcast SIGNAL...
    Alert: ENCRYPTED broadcast SIGNAL SENT
    Waiting for Incoming transmissions...
    .
    .
    .
    Information: encrypted Transmission received
    Alert: Bug Breach Detected
    Requesting Eagle 500kg Bomb
    Request for Eagle 500kg Bomb accepted
    Estimated DROP TIME: 3 seconds
""".trimIndent()
