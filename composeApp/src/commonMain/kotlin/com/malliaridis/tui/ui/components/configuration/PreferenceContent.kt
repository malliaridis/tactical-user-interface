package com.malliaridis.tui.ui.components.configuration

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.malliaridis.tui.domain.configuration.PreferencesComponent
import com.malliaridis.tui.model.PreferenceKeys
import com.malliaridis.tui.ui.components.stratagems.DialPadStyle

@Composable
fun PreferenceContent(
    component: PreferencesComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.models.collectAsState()

    val currentPreference = model.focused
    // Only the dial pad preference has currently a preview
    if (currentPreference?.id == PreferenceKeys.PK_DIALPAD_STYLE) {
        val style = currentPreference.value as? DialPadStyle
            ?: return // TODO Log invalid preference value for preference key PK_DIALPAD_STYLE
        DialPadPreferenceSelectionPreview(
            modifier = modifier,
            style = style,
        )
    } else Spacer(modifier = modifier)
}
