package com.malliaridis.tui.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.domain.common.SystemStateComponent
import com.malliaridis.tui.domain.foundation.PageComponent
import com.malliaridis.tui.domain.foundation.integration.PreferencesPageComponent
import com.malliaridis.tui.domain.foundation.integration.StratagemsPageComponent
import com.malliaridis.tui.domain.foundation.integration.TerminalPageComponent
import com.malliaridis.tui.domain.foundation.integration.TransmissionsPageComponent
import com.malliaridis.tui.getTerminalOutput
import com.malliaridis.tui.ui.components.configuration.PreferenceContent
import com.malliaridis.tui.ui.components.configuration.PreferenceMenuContent
import com.malliaridis.tui.ui.components.status.StatusBarContent
import com.malliaridis.tui.ui.components.stratagems.DialPadContent
import com.malliaridis.tui.ui.components.stratagems.StratagemListContent
import com.malliaridis.tui.ui.components.terminal.TerminalActions
import com.malliaridis.tui.ui.components.terminal.TerminalScreen
import com.malliaridis.tui.ui.components.transmissions.TransmissionListContent
import com.malliaridis.tui.ui.components.transmissions.TransmissionViewContent

@Composable
fun PageContent(
    pageComponent: PageComponent,
    systemStateComponent: SystemStateComponent,
    modifier: Modifier = Modifier,
) = Row(modifier = modifier) {
    Column(
        modifier = Modifier
            .weight(3f)
            .padding(16.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        MainSlot(
            modifier = Modifier.weight(1f),
            pageComponent = pageComponent,
        )

        StatusBarContent(component = systemStateComponent)
    }

    SideSlot(
        modifier = Modifier
            .weight(2f)
            .padding(16.dp),
        pageComponent = pageComponent,
    )
}

@Composable
private fun MainSlot(
    modifier: Modifier = Modifier,
    pageComponent: PageComponent,
) = when (pageComponent) {
    is StratagemsPageComponent -> StratagemListContent(
        modifier = modifier,
        component = pageComponent.stratagemListComponent,
    )

    is TerminalPageComponent -> TerminalScreen(
        modifier = modifier,
        output = getTerminalOutput(),
    )

    is TransmissionsPageComponent -> TransmissionListContent(
        component = pageComponent.transmissionListComponent,
        modifier = modifier,
    )

    is PreferencesPageComponent -> PreferenceMenuContent(
        component = pageComponent.preferencesComponent,
        modifier = modifier,
    )

    else -> Spacer(modifier)
}

@Composable
private fun SideSlot(
    modifier: Modifier = Modifier,
    pageComponent: PageComponent,
) = when (pageComponent) {
    is StratagemsPageComponent -> DialPadContent(
        component = pageComponent.inputComponent,
        modifier = modifier.height(intrinsicSize = IntrinsicSize.Max),
    )

    is TerminalPageComponent -> TerminalActions(modifier = modifier)
    is TransmissionsPageComponent -> {
        if (pageComponent.transmissionComponent != null) TransmissionViewContent(
            component = pageComponent.transmissionComponent,
            modifier = modifier.fillMaxHeight(),
        ) else Spacer(modifier)
    }

    is PreferencesPageComponent -> PreferenceContent(
        component = pageComponent.preferencesComponent,
        modifier = modifier,
    )

    else -> Spacer(modifier)
}
