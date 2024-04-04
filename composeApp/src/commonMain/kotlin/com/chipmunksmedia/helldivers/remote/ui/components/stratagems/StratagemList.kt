package com.chipmunksmedia.helldivers.remote.ui.components.stratagems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Stratagem
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.border
import com.chipmunksmedia.helldivers.remote.ui.utils.getStratagemDisplayName
import com.chipmunksmedia.helldivers.remote.ui.utils.getStratagemDrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun StratagemList(
    modifier: Modifier = Modifier,
    stratagems: List<Stratagem>,
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
                highlightCount = 0,
            )
        }
    }
}
