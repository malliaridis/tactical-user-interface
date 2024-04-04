package com.chipmunksmedia.helldivers.remote.ui.components.transmissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Media
import com.chipmunksmedia.helldivers.remote.model.TransmissionDetails
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.components.media.AudioPlayer
import com.chipmunksmedia.helldivers.remote.ui.components.media.VideoPlayer
import com.chipmunksmedia.helldivers.remote.ui.components.media.rememberMediaPlayerState
import com.chipmunksmedia.helldivers.remote.ui.theme.CustomColors
import com.chipmunksmedia.helldivers.remote.ui.utils.asDateTimeValue
import com.chipmunksmedia.helldivers.remote.ui.utils.toDiffStringSince

@Composable
fun TransmissionView(
    modifier: Modifier = Modifier,
    transmission: TransmissionDetails,
) = StripesDecorator(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        val media = transmission.media
        if (media != null) {
            when (media) {
                is Media.AudioMedia -> AudioPlayer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f / 1),
                    audio = media,
                    state = rememberMediaPlayerState(isResumed = false),
                )

                is Media.ImageMedia -> { /* TODO Implement me */
                }

                is Media.VideoMedia -> VideoPlayer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9),
                    url = media.uri,
                    isFullScreen = false,
                    state = rememberMediaPlayerState(),
                )
            }
        }
        Text(
            text = transmission.title,
            style = MaterialTheme.typography.titleMedium,
            color = CustomColors.textColor,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            text = transmission.content,
            style = MaterialTheme.typography.bodyMedium,
            color = CustomColors.textColorVariant,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            val until = transmission.until
            if (until != null) Text(
                modifier = Modifier.weight(1f),
                text = until.toDiffStringSince(transmission.timestamp),
                color = CustomColors.textColor,
            )
            Text(
                modifier = Modifier,
                text = transmission.timestamp.asDateTimeValue,
                color = CustomColors.textColorVariant,
            )
        }
    }
}
