package com.chipmunksmedia.helldivers.remote.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Modifiers.cornerBorder

/**
 * The status bar is a simple text with background that displays the current status.
 */
@Composable
fun StatusBar(
    status: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
) = Text(
    text = status,
    style = MaterialTheme.typography.titleMedium,
    color = if (isError) CustomColors.errorTextColor else CustomColors.textColor,
    modifier = modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(if (isError) CustomColors.dialogContainerErrorColor else CustomColors.dialogContainerColor)
        .cornerBorder(
            length = 6.dp,
            color = if (isError) CustomColors.borderErrorColor else CustomColors.borderColorVariant,
        )
        .wrapContentSize(align = Alignment.Center),
)
