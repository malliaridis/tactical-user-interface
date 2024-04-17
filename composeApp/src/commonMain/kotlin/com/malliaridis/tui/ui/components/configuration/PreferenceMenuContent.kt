package com.malliaridis.tui.ui.components.configuration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.malliaridis.tui.domain.configuration.PreferencesComponent

@Composable
fun PreferenceMenuContent(
    component: PreferencesComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.models.collectAsState()

    PreferenceMenu(
        modifier = modifier,
        preferences = model.values,
        selectedPreference = model.focused,
        onPreferenceSelected = component::onSelectPreference,
        onPreferenceUpdated = component::onUpdatePreference,
        onNavigateBack = { component.onSelectPreference(null) }
    )
}
