package com.malliaridis.tui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import tacticaluserinterface.composeapp.generated.resources.Res
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_bold
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_bold_italic
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_italic
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_light
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_light_italic
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_medium
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_medium_italic
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_regular
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_semibold
import tacticaluserinterface.composeapp.generated.resources.chakra_petch_semibold_italic
import tacticaluserinterface.composeapp.generated.resources.vt323_regular

@OptIn(ExperimentalResourceApi::class)
object Fonts {

    @Composable
    fun chakraPetchFont() = FontFamily(
        Font(
            resource = Res.font.chakra_petch_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.chakra_petch_light_italic,
            weight = FontWeight.Light,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.chakra_petch_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.chakra_petch_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.chakra_petch_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.chakra_petch_medium_italic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.chakra_petch_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.chakra_petch_semibold_italic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.chakra_petch_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.chakra_petch_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic,
        ),
    )

    @Composable
    fun vt323Font() = FontFamily(
        Font(resource = Res.font.vt323_regular),
    )
}

@Composable
internal fun HelldiversTypography(): Typography {
    val fontFamily = Fonts.chakraPetchFont()

    return Typography(
        displayLarge = TextStyle(
            fontSize = 57.sp,
            fontFamily = fontFamily,
            letterSpacing = (-0.25).sp,
            lineHeight = 64.sp,
        ),
        displayMedium = TextStyle(
            fontSize = 45.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 52.sp,
        ),
        displaySmall = TextStyle(
            fontSize = 36.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 44.sp,
        ),
        headlineLarge = TextStyle(
            fontSize = 32.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 40.sp,
        ),
        headlineMedium = TextStyle(
            fontSize = 28.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 36.sp,
        ),
        headlineSmall = TextStyle(
            fontSize = 24.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 32.sp,
        ),
        titleLarge = TextStyle(
            fontSize = 22.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 28.sp,
        ),
        titleMedium = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            letterSpacing = 0.15.sp,
            lineHeight = 24.sp,
        ),
        titleSmall = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            letterSpacing = 0.1.sp,
            lineHeight = 20.sp,
        ),
        bodyLarge = TextStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.5.sp,
            lineHeight = 24.sp,
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.25.sp,
            lineHeight = 20.sp,
        ),
        bodySmall = TextStyle(
            fontSize = 12.sp,
            fontFamily = fontFamily,
            letterSpacing = 0.4.sp,
            lineHeight = 16.sp,
        ),
        labelLarge = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            letterSpacing = 0.1.sp,
            lineHeight = 20.sp,
        ),
        labelMedium = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            letterSpacing = 0.5.sp,
            lineHeight = 16.sp,
        ),
        labelSmall = TextStyle(
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            letterSpacing = 0.5.sp,
            lineHeight = 16.sp,
        ),
    )
}
