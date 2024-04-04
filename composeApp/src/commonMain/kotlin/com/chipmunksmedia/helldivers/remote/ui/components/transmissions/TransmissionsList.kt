package com.chipmunksmedia.helldivers.remote.ui.components.transmissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.TransmissionListEntry
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.border

@Composable
fun TransmissionsList(
    modifier: Modifier = Modifier,
    transmissions: List<TransmissionListEntry>,
    onTransmissionClick: (String) -> Unit,
    selectedTransmissionId: String? = null,
) = StripesDecorator(modifier = modifier.border(top = 1.5.dp, color = CustomColors.borderColorVariant)) {
    LazyColumn(
        modifier = Modifier.padding(top = 1.5.dp), // to avoid overlap with border
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(transmissions) { transmission ->
            TransmissionListItem(
                transmission = transmission,
                isSelected = transmission.id == selectedTransmissionId,
                onClick = { onTransmissionClick(transmission.id) },
            )
        }
    }
}
