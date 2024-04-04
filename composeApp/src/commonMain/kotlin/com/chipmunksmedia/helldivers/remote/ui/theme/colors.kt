package com.chipmunksmedia.helldivers.remote.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Custom colors is a collection of colors used aside the main material theming. These colors
 * should ideally be deprecated and removed once the material themes are updated with the correct colors.
 */
object CustomColors {

    val terminalBackground: Color = Color(0xFF14140C)
    val terminalTextColor: Color = Color(0xFFCACA8B)
    val terminalBorder: Color = terminalTextColor

    val seedColor = Color(0xFFFFE900)
    val accentColor = Color(0xFFC9B169)

    val textColor = Color.White
    val textColorVariant = Color(0xFFAFAFAF)
    val errorTextColor = Color(0xFFFFBB25)

    val borderColor = Color(0xFF676767)
    val borderColorVariant = Color(0xFF7A776F)
    val borderColorFocused = Color.White
    val borderErrorColor = Color(0xFF803030)

    val stripesColor = Color(0xFF686868)

    val backgroundColorPrimary = Color(0xFF000520)
    val backgroundColorSecondary = Color(0xFF001040)

    val backgroundColorPrimaryError = Color(0xFF200500)
    val backgroundColorSecondaryError = Color(0xFF401000)

    val dialogContainerColor = Color(0xB3484646)
    val dialogContainerErrorColor = Color(0xB3500000)

    val dialPadContainerColor = Color(0xFF494740)
    val dialPadBackgroundColor = borderColorVariant
    val dialPadContainerColorPressed = seedColor.copy(alpha = .5f)
    val dialPadBackgroundColorPressed = seedColor

    val buttonBackgroundColor: Color = Color.Black.copy(alpha = 0.5f)
}

val primaryLight = Color(0xFF695F00)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFFFEE90D)
val onPrimaryContainerLight = Color(0xFF534B00)
val secondaryLight = Color(0xFF685F11)
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFF5E98D)
val onSecondaryContainerLight = Color(0xFF534B00)
val tertiaryLight = Color(0xFF496800)
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFC3F95B)
val onTertiaryContainerLight = Color(0xFF395200)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF410002)
val backgroundLight = Color(0xFFFFF9E7)
val onBackgroundLight = Color(0xFF1E1C10)
val surfaceLight = Color(0xFFFFF9E7)
val onSurfaceLight = Color(0xFF1E1C10)
val surfaceVariantLight = Color(0xFFE9E3C5)
val onSurfaceVariantLight = Color(0xFF4B4732)
val outlineLight = Color(0xFF7C785F)
val outlineVariantLight = Color(0xFFCDC7AB)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF333123)
val inverseOnSurfaceLight = Color(0xFFF7F1DD)
val inversePrimaryLight = Color(0xFFDBC900)
val surfaceDimLight = Color(0xFFDFDAC7)
val surfaceBrightLight = Color(0xFFFFF9E7)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF9F4E0)
val surfaceContainerLight = Color(0xFFF4EEDA)
val surfaceContainerHighLight = Color(0xFFEEE8D4)
val surfaceContainerHighestLight = Color(0xFFE8E2CF)

val primaryLightMediumContrast = Color(0xFF4B4400)
val onPrimaryLightMediumContrast = Color(0xFFFFFFFF)
val primaryContainerLightMediumContrast = Color(0xFF817600)
val onPrimaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val secondaryLightMediumContrast = Color(0xFF4B4400)
val onSecondaryLightMediumContrast = Color(0xFFFFFFFF)
val secondaryContainerLightMediumContrast = Color(0xFF7F7627)
val onSecondaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val tertiaryLightMediumContrast = Color(0xFF334A00)
val onTertiaryLightMediumContrast = Color(0xFFFFFFFF)
val tertiaryContainerLightMediumContrast = Color(0xFF5A8000)
val onTertiaryContainerLightMediumContrast = Color(0xFFFFFFFF)
val errorLightMediumContrast = Color(0xFF8C0009)
val onErrorLightMediumContrast = Color(0xFFFFFFFF)
val errorContainerLightMediumContrast = Color(0xFFDA342E)
val onErrorContainerLightMediumContrast = Color(0xFFFFFFFF)
val backgroundLightMediumContrast = Color(0xFFFFF9E7)
val onBackgroundLightMediumContrast = Color(0xFF1E1C10)
val surfaceLightMediumContrast = Color(0xFFFFF9E7)
val onSurfaceLightMediumContrast = Color(0xFF1E1C10)
val surfaceVariantLightMediumContrast = Color(0xFFE9E3C5)
val onSurfaceVariantLightMediumContrast = Color(0xFF47432E)
val outlineLightMediumContrast = Color(0xFF636048)
val outlineVariantLightMediumContrast = Color(0xFF807B62)
val scrimLightMediumContrast = Color(0xFF000000)
val inverseSurfaceLightMediumContrast = Color(0xFF333123)
val inverseOnSurfaceLightMediumContrast = Color(0xFFF7F1DD)
val inversePrimaryLightMediumContrast = Color(0xFFDBC900)
val surfaceDimLightMediumContrast = Color(0xFFDFDAC7)
val surfaceBrightLightMediumContrast = Color(0xFFFFF9E7)
val surfaceContainerLowestLightMediumContrast = Color(0xFFFFFFFF)
val surfaceContainerLowLightMediumContrast = Color(0xFFF9F4E0)
val surfaceContainerLightMediumContrast = Color(0xFFF4EEDA)
val surfaceContainerHighLightMediumContrast = Color(0xFFEEE8D4)
val surfaceContainerHighestLightMediumContrast = Color(0xFFE8E2CF)

val primaryLightHighContrast = Color(0xFF272300)
val onPrimaryLightHighContrast = Color(0xFFFFFFFF)
val primaryContainerLightHighContrast = Color(0xFF4B4400)
val onPrimaryContainerLightHighContrast = Color(0xFFFFFFFF)
val secondaryLightHighContrast = Color(0xFF272300)
val onSecondaryLightHighContrast = Color(0xFFFFFFFF)
val secondaryContainerLightHighContrast = Color(0xFF4B4400)
val onSecondaryContainerLightHighContrast = Color(0xFFFFFFFF)
val tertiaryLightHighContrast = Color(0xFF192600)
val onTertiaryLightHighContrast = Color(0xFFFFFFFF)
val tertiaryContainerLightHighContrast = Color(0xFF334A00)
val onTertiaryContainerLightHighContrast = Color(0xFFFFFFFF)
val errorLightHighContrast = Color(0xFF4E0002)
val onErrorLightHighContrast = Color(0xFFFFFFFF)
val errorContainerLightHighContrast = Color(0xFF8C0009)
val onErrorContainerLightHighContrast = Color(0xFFFFFFFF)
val backgroundLightHighContrast = Color(0xFFFFF9E7)
val onBackgroundLightHighContrast = Color(0xFF1E1C10)
val surfaceLightHighContrast = Color(0xFFFFF9E7)
val onSurfaceLightHighContrast = Color(0xFF000000)
val surfaceVariantLightHighContrast = Color(0xFFE9E3C5)
val onSurfaceVariantLightHighContrast = Color(0xFF272411)
val outlineLightHighContrast = Color(0xFF47432E)
val outlineVariantLightHighContrast = Color(0xFF47432E)
val scrimLightHighContrast = Color(0xFF000000)
val inverseSurfaceLightHighContrast = Color(0xFF333123)
val inverseOnSurfaceLightHighContrast = Color(0xFFFFFFFF)
val inversePrimaryLightHighContrast = Color(0xFFFFEF6B)
val surfaceDimLightHighContrast = Color(0xFFDFDAC7)
val surfaceBrightLightHighContrast = Color(0xFFFFF9E7)
val surfaceContainerLowestLightHighContrast = Color(0xFFFFFFFF)
val surfaceContainerLowLightHighContrast = Color(0xFFF9F4E0)
val surfaceContainerLightHighContrast = Color(0xFFF4EEDA)
val surfaceContainerHighLightHighContrast = Color(0xFFEEE8D4)
val surfaceContainerHighestLightHighContrast = Color(0xFFE8E2CF)

val primaryDark = Color(0xFFFFFFFF)
val onPrimaryDark = Color(0xFF363100)
val primaryContainerDark = Color(0xFFEAD700)
val onPrimaryContainerDark = Color(0xFF474000)
val secondaryDark = Color(0xFFD4C871)
val onSecondaryDark = Color(0xFF363100)
val secondaryContainerDark = Color(0xFF4C4500)
val onSecondaryContainerDark = Color(0xFFEADE84)
val tertiaryDark = Color(0xFFFFFFFF)
val onTertiaryDark = Color(0xFF243600)
val tertiaryContainerDark = Color(0xFFB0E54A)
val onTertiaryContainerDark = Color(0xFF304600)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)
val backgroundDark = Color(0xFF151408)
val onBackgroundDark = Color(0xFFE8E2CF)
val surfaceDark = Color(0xFF151408)
val onSurfaceDark = Color(0xFFE8E2CF)
val surfaceVariantDark = Color(0xFF4B4732)
val onSurfaceVariantDark = Color(0xFFCDC7AB)
val outlineDark = Color(0xFF969177)
val outlineVariantDark = Color(0xFF4B4732)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFFE8E2CF)
val inverseOnSurfaceDark = Color(0xFF333123)
val inversePrimaryDark = Color(0xFF695F00)
val surfaceDimDark = Color(0xFF151408)
val surfaceBrightDark = Color(0xFF3C392C)
val surfaceContainerLowestDark = Color(0xFF100E05)
val surfaceContainerLowDark = Color(0xFF1E1C10)
val surfaceContainerDark = Color(0xFF222014)
val surfaceContainerHighDark = Color(0xFF2C2A1D)
val surfaceContainerHighestDark = Color(0xFF373528)

val primaryDarkMediumContrast = Color(0xFFFFFFFF)
val onPrimaryDarkMediumContrast = Color(0xFF363100)
val primaryContainerDarkMediumContrast = Color(0xFFEAD700)
val onPrimaryContainerDarkMediumContrast = Color(0xFF242000)
val secondaryDarkMediumContrast = Color(0xFFD8CD74)
val onSecondaryDarkMediumContrast = Color(0xFF1A1700)
val secondaryContainerDarkMediumContrast = Color(0xFF9C9241)
val onSecondaryContainerDarkMediumContrast = Color(0xFF000000)
val tertiaryDarkMediumContrast = Color(0xFFFFFFFF)
val onTertiaryDarkMediumContrast = Color(0xFF243600)
val tertiaryContainerDarkMediumContrast = Color(0xFFB0E54A)
val onTertiaryContainerDarkMediumContrast = Color(0xFF162300)
val errorDarkMediumContrast = Color(0xFFFFBAB1)
val onErrorDarkMediumContrast = Color(0xFF370001)
val errorContainerDarkMediumContrast = Color(0xFFFF5449)
val onErrorContainerDarkMediumContrast = Color(0xFF000000)
val backgroundDarkMediumContrast = Color(0xFF151408)
val onBackgroundDarkMediumContrast = Color(0xFFE8E2CF)
val surfaceDarkMediumContrast = Color(0xFF151408)
val onSurfaceDarkMediumContrast = Color(0xFFFFFAF2)
val surfaceVariantDarkMediumContrast = Color(0xFF4B4732)
val onSurfaceVariantDarkMediumContrast = Color(0xFFD1CBAF)
val outlineDarkMediumContrast = Color(0xFFA9A389)
val outlineVariantDarkMediumContrast = Color(0xFF88846A)
val scrimDarkMediumContrast = Color(0xFF000000)
val inverseSurfaceDarkMediumContrast = Color(0xFFE8E2CF)
val inverseOnSurfaceDarkMediumContrast = Color(0xFF2C2A1D)
val inversePrimaryDarkMediumContrast = Color(0xFF504900)
val surfaceDimDarkMediumContrast = Color(0xFF151408)
val surfaceBrightDarkMediumContrast = Color(0xFF3C392C)
val surfaceContainerLowestDarkMediumContrast = Color(0xFF100E05)
val surfaceContainerLowDarkMediumContrast = Color(0xFF1E1C10)
val surfaceContainerDarkMediumContrast = Color(0xFF222014)
val surfaceContainerHighDarkMediumContrast = Color(0xFF2C2A1D)
val surfaceContainerHighestDarkMediumContrast = Color(0xFF373528)

val primaryDarkHighContrast = Color(0xFFFFFFFF)
val onPrimaryDarkHighContrast = Color(0xFF000000)
val primaryContainerDarkHighContrast = Color(0xFFEAD700)
val onPrimaryContainerDarkHighContrast = Color(0xFF000000)
val secondaryDarkHighContrast = Color(0xFFFFFAF2)
val onSecondaryDarkHighContrast = Color(0xFF000000)
val secondaryContainerDarkHighContrast = Color(0xFFD8CD74)
val onSecondaryContainerDarkHighContrast = Color(0xFF000000)
val tertiaryDarkHighContrast = Color(0xFFFFFFFF)
val onTertiaryDarkHighContrast = Color(0xFF000000)
val tertiaryContainerDarkHighContrast = Color(0xFFB0E54A)
val onTertiaryContainerDarkHighContrast = Color(0xFF000000)
val errorDarkHighContrast = Color(0xFFFFF9F9)
val onErrorDarkHighContrast = Color(0xFF000000)
val errorContainerDarkHighContrast = Color(0xFFFFBAB1)
val onErrorContainerDarkHighContrast = Color(0xFF000000)
val backgroundDarkHighContrast = Color(0xFF151408)
val onBackgroundDarkHighContrast = Color(0xFFE8E2CF)
val surfaceDarkHighContrast = Color(0xFF151408)
val onSurfaceDarkHighContrast = Color(0xFFFFFFFF)
val surfaceVariantDarkHighContrast = Color(0xFF4B4732)
val onSurfaceVariantDarkHighContrast = Color(0xFFFFFAF2)
val outlineDarkHighContrast = Color(0xFFD1CBAF)
val outlineVariantDarkHighContrast = Color(0xFFD1CBAF)
val scrimDarkHighContrast = Color(0xFF000000)
val inverseSurfaceDarkHighContrast = Color(0xFFE8E2CF)
val inverseOnSurfaceDarkHighContrast = Color(0xFF000000)
val inversePrimaryDarkHighContrast = Color(0xFF2F2B00)
val surfaceDimDarkHighContrast = Color(0xFF151408)
val surfaceBrightDarkHighContrast = Color(0xFF3C392C)
val surfaceContainerLowestDarkHighContrast = Color(0xFF100E05)
val surfaceContainerLowDarkHighContrast = Color(0xFF1E1C10)
val surfaceContainerDarkHighContrast = Color(0xFF222014)
val surfaceContainerHighDarkHighContrast = Color(0xFF2C2A1D)
val surfaceContainerHighestDarkHighContrast = Color(0xFF373528)

internal val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

internal val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

internal val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

internal val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

internal val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

internal val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    color = Color.Unspecified,
    onColor = Color.Unspecified,
    colorContainer = Color.Unspecified,
    onColorContainer = Color.Unspecified,
)
