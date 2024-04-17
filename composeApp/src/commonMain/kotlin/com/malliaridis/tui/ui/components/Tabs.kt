package com.malliaridis.tui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.model.AppTab
import com.malliaridis.tui.ui.theme.CustomColors
import com.malliaridis.tui.ui.theme.Modifiers.border

/**
 * The simplified tab row uses a [Row] for the tabs and is not scrollable.
 */
@Composable
fun SimplifiedTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    onTabClick: (index: Int) -> Unit,
) {
    Row(
        modifier = modifier
            .requiredWidth(IntrinsicSize.Min)
            .defaultMinSize(minHeight = 38.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AppTab.entries.forEachIndexed { index, tab ->
            Tab(
                modifier = Modifier.weight(1f),
                label = tab.name,
                selected = selectedTabIndex == index,
                onClick = { onTabClick(index) }
            )
        }
    }
}

@Composable
fun Tab(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    val borderColor by animateColorAsState(
        targetValue = if (selected) CustomColors.borderColorFocused else CustomColors.borderColor
    )

    val fontColor by animateColorAsState(
        targetValue = if (selected) CustomColors.textColor else CustomColors.textColorVariant
    )

    Column(
        modifier = modifier
            .clickable { onClick() }
            .border(
                left = 1.dp,
                right = 1.dp,
                bottom = 1.dp,
                color = borderColor,
            )
            .padding(6.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = label.uppercase(),
            style = MaterialTheme.typography.titleSmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = fontColor,
        )
        AnimatedVisibility(visible = selected) {
            StripedSurface(modifier = Modifier.fillMaxWidth().height(6.dp))
        }
    }
}
