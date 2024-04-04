package com.chipmunksmedia.helldivers.remote.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.border

@Composable
fun ActionButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    if (isSelected) modifier.border(left = 2.dp, color = CustomColors.seedColor)

    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = CustomColors.buttonBackgroundColor,
            contentColor = Color(0xFFB1B1B1),
        ),
        shape = RectangleShape,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(all = 12.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text.uppercase(),
            style = MaterialTheme.typography.labelLarge,
        )
    }
}
