package com.chipmunksmedia.helldivers.remote.ui.components.configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.AppPreference
import com.chipmunksmedia.helldivers.remote.ui.components.ActionButton
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.border
import com.chipmunksmedia.helldivers.remote.ui.utils.getDisplayName
import com.chipmunksmedia.helldivers.remote.ui.utils.getPreferenceValueDisplayName
import helldiversremote.composeapp.generated.resources.Res
import helldiversremote.composeapp.generated.resources.back
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PreferenceMenu(
    modifier: Modifier = Modifier,
    preferences: List<AppPreference>,
    selectedPreference: AppPreference?,
    onPreferenceSelected: (AppPreference) -> Unit,
    onPreferenceUpdated: (AppPreference) -> Unit,
    onNavigateBack: () -> Unit,
) = StripesDecorator(modifier = modifier.border(top = 1.5.dp, color = CustomColors.borderColorVariant)) {
    LazyColumn(
        modifier = Modifier.padding(top = 1.5.dp), // to avoid overlap with border
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        if (selectedPreference != null) {
            item {
                ActionButton(
                    onClick = onNavigateBack,
                    text = selectedPreference.getDisplayName(),
                    isSelected = true,
                )
            }
            when (selectedPreference) {
                is AppPreference.SelectionPreference -> {
                    preferenceValues(
                        values = selectedPreference.availableValues,
                        selectedValue = selectedPreference.selectedValue,
                        onClick = {
                            onPreferenceUpdated(selectedPreference.copy(selectedValue = it))
                        }
                    )
                }

                else -> error("Unsupported preference nesting provided")
            }
            item {
                ActionButton(
                    onClick = onNavigateBack,
                    text = stringResource(Res.string.back),
                )
            }
        } else items(preferences) { preference ->
            ActionButton(
                onClick = { onPreferenceSelected(preference) },
                text = preference.getDisplayName(),
            )
        }
    }
}

fun LazyListScope.preferenceValues(
    values: List<String>,
    selectedValue: String,
    onClick: (String) -> Unit,
) = items(values) { value ->
    ActionButton(
        onClick = { onClick(value) },
        text = getPreferenceValueDisplayName(value),
        isSelected = selectedValue == value,
    )
}
