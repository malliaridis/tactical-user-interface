package com.malliaridis.tui.ui.components.stratagems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.model.Stratagem
import com.malliaridis.tui.ui.components.StripesDecorator
import com.malliaridis.tui.ui.theme.CustomColors
import com.malliaridis.tui.ui.theme.Modifiers.border
import com.malliaridis.tui.ui.utils.getStratagemDisplayName
import com.malliaridis.tui.ui.utils.getStratagemDrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun StratagemList(
    modifier: Modifier = Modifier,
    stratagems: List<Stratagem>,
    highlightCount: Int = 0,
) = StripesDecorator(
    modifier = modifier,
    horizontalArrangement = Arrangement.Start,
) {
    LazyColumn(
        modifier = Modifier
            .border(
                top = 1.5.dp,
                color = CustomColors.borderColorVariant,
            )
            .padding(vertical = 8.dp),
    ) {
        items(stratagems) { stratagem ->
            StratagemListEntry(
                displayName = getStratagemDisplayName(stratagem.id),
                drawable = getStratagemDrawableResource(stratagem.id),
                dialCode = stratagem.dialCode,
                highlightCount = highlightCount,
            )
        }
    }
}
