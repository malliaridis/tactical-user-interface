package com.chipmunksmedia.helldivers.remote.ui.components.configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.AppPreference
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadCircleDrawables
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadRectangular
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadStyle
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadSwipe
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.utils.getDirectionDisplayName
import helldiversremote.composeapp.generated.resources.Res
import helldiversremote.composeapp.generated.resources.hint_double_tap_for_action
import helldiversremote.composeapp.generated.resources.hint_swipe_for_direction
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun DialPadPreferenceSelectionPreview(
    modifier: Modifier = Modifier,
    preference: AppPreference.SelectionPreference,
) = StripesDecorator(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    rtl = true,
) {
    Box(Modifier.padding(8.dp).weight(1f)) {
        when (DialPadStyle.valueOf(preference.selectedValue)) {
            DialPadStyle.SwipePad -> {
                DialPadSwipe(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(.7f),
                    onDirectionDetect = {}
                )
                HintTextsSwipePad()
            }

            DialPadStyle.Circular -> {
                DialPadCircleDrawables(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(.7f),
                    onClick = {},
                )
                HintTextsCircularPad()
            }

            DialPadStyle.Rectangular -> {
                DialPadRectangular(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(.7f),
                    onClick = {},
                )
                HintTextsRectangularPad()
            }
        }
    }
}

@Composable
fun HintTextsRectangularPad() = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(8.dp),
) {
    Row(
        modifier = Modifier.weight(2f),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HintText(
            modifier = Modifier
                .weight(3f)
                .align(Alignment.CenterVertically),
            text = getDirectionDisplayName(Direction.Left),
        )
        Column(
            modifier = Modifier.weight(5f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            HintText(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .align(Alignment.CenterHorizontally),
                text = getDirectionDisplayName(Direction.Up),
            )
            HintText(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .align(Alignment.CenterHorizontally),
                text = getDirectionDisplayName(Direction.Down),
            )
        }
        HintText(
            modifier = Modifier
                .weight(3f)
                .align(Alignment.CenterVertically),
            text = getDirectionDisplayName(Direction.Right),
        )
    }
    HintText(
        modifier = Modifier
            .weight(1f)
            .wrapContentSize(Alignment.Center)
            .align(Alignment.CenterHorizontally),
        text = getDirectionDisplayName(Direction.Center),
    )
}

@Composable
private fun BoxScope.HintTextsCircularPad() {
    (Direction.entries - Direction.None).forEach { direction ->
        DirectionDescription(direction)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BoxScope.HintTextsSwipePad() = Column(
    modifier = Modifier.align(Alignment.Center),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    HintText(stringResource(Res.string.hint_double_tap_for_action))
    HintText(stringResource(Res.string.hint_swipe_for_direction))
}

@Composable
private fun BoxScope.DirectionDescription(
    direction: Direction,
) = HintText(
    modifier = Modifier
        .align(direction.asAlignment)
        .padding(
            horizontal = 24.dp,
            vertical = 40.dp,
        ),
    text = getDirectionDisplayName(direction),
)

@Composable
private fun HintText(
    text: String,
    modifier: Modifier = Modifier,
) = Text(
    modifier = modifier,
    text = text,
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.labelMedium,
    color = CustomColors.textColor,
)

private val Direction.asAlignment: Alignment
    get() = when (this) {
        Direction.None -> Alignment.Center
        Direction.Up -> Alignment.TopCenter
        Direction.Down -> Alignment.BottomCenter
        Direction.Left -> Alignment.CenterStart
        Direction.Right -> Alignment.CenterEnd
        Direction.Center -> Alignment.Center
    }
