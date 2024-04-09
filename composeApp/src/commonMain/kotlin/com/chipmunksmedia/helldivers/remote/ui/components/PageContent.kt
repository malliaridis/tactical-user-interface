package com.chipmunksmedia.helldivers.remote.ui.components

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
import com.chipmunksmedia.helldivers.remote.domain.common.SystemStateComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.PageComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.PreferencesPageComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.StratagemsPageComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.TerminalPageComponent
import com.chipmunksmedia.helldivers.remote.domain.foundation.integration.TransmissionsPageComponent
import com.chipmunksmedia.helldivers.remote.getTerminalOutput
import com.chipmunksmedia.helldivers.remote.ui.components.configuration.PreferenceContent
import com.chipmunksmedia.helldivers.remote.ui.components.configuration.PreferenceMenuContent
import com.chipmunksmedia.helldivers.remote.ui.components.status.StatusBarContent
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadContent
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.StratagemListContent
import com.chipmunksmedia.helldivers.remote.ui.components.terminal.TerminalActions
import com.chipmunksmedia.helldivers.remote.ui.components.terminal.TerminalScreen
import com.chipmunksmedia.helldivers.remote.ui.components.transmissions.TransmissionListContent
import com.chipmunksmedia.helldivers.remote.ui.components.transmissions.TransmissionViewContent

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
