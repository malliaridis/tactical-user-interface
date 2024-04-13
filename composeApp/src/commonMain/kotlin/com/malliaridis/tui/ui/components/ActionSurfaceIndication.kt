package com.malliaridis.tui.ui.components

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.dp
import com.malliaridis.tui.ui.theme.CustomColors

class ActionSurfaceIndication(
    val pressColor: Color = CustomColors.seedColor,
    val alpha: Float = 0.5f,
) : Indication {

    private inner class DefaultIndicationInstance(
        private var isPressed: State<Boolean>,
    ) : IndicationInstance {

        override fun ContentDrawScope.drawIndication() {
            when {
                isPressed.value -> {
                    drawRect(
                        color = pressColor.copy(alpha = alpha),
                        topLeft = Offset(0f, 0f),
                        size = size,
                    )
                    drawRect(
                        color = pressColor,
                        topLeft = Offset(0f, 0f),
                        size = Size(width = 2.dp.toPx(), height = size.height),
                    )
                }
            }
            drawContent()
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()

        return remember(interactionSource) {
            DefaultIndicationInstance(isPressed)
        }
    }
}
