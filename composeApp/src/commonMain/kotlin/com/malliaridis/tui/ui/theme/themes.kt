package com.malliaridis.tui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HelldiversTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) darkScheme else lightScheme

    MaterialTheme(
        colorScheme = colors,
        shapes = HelldiversShapes,
        typography = HelldiversTypography(),
        content = content,
    )
}
