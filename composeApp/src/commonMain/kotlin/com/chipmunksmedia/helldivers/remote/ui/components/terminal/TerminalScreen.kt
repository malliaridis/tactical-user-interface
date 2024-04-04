package com.chipmunksmedia.helldivers.remote.ui.components.terminal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.theme.Fonts

@Composable
fun TerminalScreen(
    modifier: Modifier = Modifier,
    output: String,
) = StripesDecorator(
    modifier = modifier.height(IntrinsicSize.Max),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(CustomColors.terminalBackground)
//            .border(width = 1.dp, color = CustomColors.terminalBorder)
//            .padding(8.dp),
//        verticalArrangement = Arrangement.Bottom,
    Surface(
        modifier = modifier.fillMaxSize(),
        color = CustomColors.terminalBackground,
        border = BorderStroke(width = 1.dp, color = CustomColors.terminalBorder),
    ) {
        Text(
            text = output.uppercase(),
            modifier = Modifier
                .padding(8.dp)
                .wrapContentHeight(
                    align = Alignment.Bottom,
                    unbounded = true,
                ),
            color = CustomColors.terminalTextColor,
            fontFamily = Fonts.vt323Font(),
        )
    }
}
