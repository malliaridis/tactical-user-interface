package com.malliaridis.tui.ui.components.configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.model.AppPreference
import com.malliaridis.tui.ui.components.ActionButton
import com.malliaridis.tui.ui.components.StripesDecorator
import com.malliaridis.tui.ui.theme.CustomColors
import com.malliaridis.tui.ui.theme.Modifiers.border
import com.malliaridis.tui.ui.utils.getDisplayName
import com.malliaridis.tui.ui.utils.getPreferenceValueDisplayName
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import tacticaluserinterface.composeapp.generated.resources.Res
import tacticaluserinterface.composeapp.generated.resources.back

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PreferenceMenu(
    modifier: Modifier = Modifier,
    preferences: List<AppPreference<*>>,
    selectedPreference: AppPreference<*>?,
    onPreferenceSelected: (AppPreference<*>) -> Unit,
    onPreferenceUpdated: (String, Any?) -> Unit,
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
                is AppPreference.ListPreference -> {
                    preferenceValues(
                        values = selectedPreference.validValues,
                        selectedValue = selectedPreference.value,
                        onClick = {
                            onPreferenceUpdated(selectedPreference.id, it)
                        }
                    )
                    item {
                        ActionButton(
                            onClick = onNavigateBack,
                            text = stringResource(Res.string.back),
                        )
                    }
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
    values: List<Any?>,
    selectedValue: Any?,
    onClick: (Any?) -> Unit,
) = items(values) { value ->
    ActionButton(
        onClick = { onClick(value) },
        text = getPreferenceValueDisplayName(value.toString()),
        isSelected = selectedValue == value,
    )
}
