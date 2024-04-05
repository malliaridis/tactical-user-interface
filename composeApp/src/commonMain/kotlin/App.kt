import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.chipmunksmedia.helldivers.remote.model.Direction.Down
import com.chipmunksmedia.helldivers.remote.model.Direction.Left
import com.chipmunksmedia.helldivers.remote.model.Direction.Right
import com.chipmunksmedia.helldivers.remote.model.Direction.Up
import com.chipmunksmedia.helldivers.remote.model.Media
import com.chipmunksmedia.helldivers.remote.model.Stratagem
import com.chipmunksmedia.helldivers.remote.model.TransmissionDetails
import com.chipmunksmedia.helldivers.remote.model.TransmissionListEntry
import com.chipmunksmedia.helldivers.remote.model.TransmissionType
import com.chipmunksmedia.helldivers.remote.ui.components.AppContainer
import com.chipmunksmedia.helldivers.remote.ui.components.SimplifiedTabRow
import com.chipmunksmedia.helldivers.remote.ui.components.StatusBar
import com.chipmunksmedia.helldivers.remote.ui.components.StripesDecorator
import com.chipmunksmedia.helldivers.remote.ui.components.configuration.DialPadPreferenceSelectionPreview
import com.chipmunksmedia.helldivers.remote.ui.components.configuration.PreferenceMenu
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPad
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadStyle
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.StratagemList
import com.chipmunksmedia.helldivers.remote.ui.components.terminal.TerminalActions
import com.chipmunksmedia.helldivers.remote.ui.components.terminal.TerminalScreen
import com.chipmunksmedia.helldivers.remote.ui.components.transmissions.TransmissionView
import com.chipmunksmedia.helldivers.remote.ui.components.transmissions.TransmissionsList
import com.chipmunksmedia.helldivers.remote.ui.model.AppPreference
import com.chipmunksmedia.helldivers.remote.ui.model.AppTab
import com.chipmunksmedia.helldivers.remote.ui.model.PreferenceKeys
import com.chipmunksmedia.helldivers.remote.ui.theme.HelldiversTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    HelldiversTheme(useDarkTheme = true) {

        var selectedTab by remember { mutableStateOf(AppTab.Stratagems) }

        AppContainer(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SimplifiedTabRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .wrapContentWidth(align = Alignment.Start),
                    selectedTabIndex = selectedTab.ordinal,
                ) { tab -> selectedTab = tab }

                // TODO Consider moving out frame (row and column) and replacing only affected components
                when (selectedTab) {
                    AppTab.Stratagems -> StratagemsContent()
                    AppTab.Terminal -> TerminalContent()
                    AppTab.Transmissions -> TransmissionContent()
                    AppTab.Configuration -> ConfigurationContent()
                }
            }
        }
    }
}

@Composable
fun StratagemsContent() {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            StratagemList(
                modifier = Modifier.weight(1f),
                stratagems = getStratagems(),
            )

            StatusBar(status = "All Systems Operational")
        }

        StripesDecorator(
            modifier = Modifier
                .weight(2f)
                .height(intrinsicSize = IntrinsicSize.Max)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            rtl = true,
        ) {
            DialPad(
                modifier = Modifier
                    .alpha(.7f)
                    .weight(1f)
                    .aspectRatio(1f),
                style = DialPadStyle.SwipePad,
                onDirectionDetect = { println(it) },
            )
        }
    }
}

@Composable
fun TerminalContent() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TerminalScreen(
                modifier = Modifier.weight(1f),
                output = getTerminalOutput(),
            )
            StatusBar(status = "All Systems Operational")
        }

        TerminalActions(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp),
        )
    }
}

@Composable
fun TransmissionContent() {
    var selectedTransmission by remember { mutableStateOf<String?>(null) }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TransmissionsList(
                modifier = Modifier.weight(1f),
                transmissions = getTransmissionList(),
                onTransmissionClick = { selectedTransmission = it },
                selectedTransmissionId = selectedTransmission,
            )
            StatusBar(status = "All Systems Operational")
        }

        val actualTransmissionId = selectedTransmission
        if (actualTransmissionId != null) TransmissionView(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
                .padding(16.dp),
            transmission = getTransmissionDetailsById(actualTransmissionId)
        )
        else Spacer(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp),
        )
    }
}

@Composable
fun ConfigurationContent() {
    // preferenceHierarchy may be a nested preference tree
    var selectedPreference by remember { mutableStateOf<AppPreference?>(null) }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PreferenceMenu(
                modifier = Modifier.weight(1f),
                preferences = getPreferences(),
                selectedPreference = selectedPreference,
                onPreferenceSelected = { preference ->
                    if (preference is AppPreference.SelectionPreference) selectedPreference = preference
                    else Unit // TODO Handle links and deep links
                },
                onPreferenceUpdated = { selectedPreference = it },
                onNavigateBack = { selectedPreference = null }
            )
            StatusBar(status = "All Systems Operational")
        }

        val actualPreference = selectedPreference
        // Only the dial pad preference has currently a preview
        if (actualPreference?.id == PreferenceKeys.PK_DIALPAD_STYLE) DialPadPreferenceSelectionPreview(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp),
            preference = actualPreference as AppPreference.SelectionPreference,
        ) else Spacer(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp),
        )
    }
}

// TODO Use component state instead
private fun getStratagems() = listOf(
    Stratagem(
        id = "st_reinforce",
        dialCode = arrayOf(Up, Down, Right, Left, Up),
    ),
    Stratagem(
        id = "st_resupply",
        dialCode = arrayOf(Down, Down, Up, Right),
    ),
    Stratagem(
        id = "st_hellbomb",
        dialCode = arrayOf(Down, Up, Left, Down, Up, Right, Down, Up),
    ),
)

private fun getTransmissionList() = listOf(
    TransmissionListEntry(
        id = "random-id-83155",
        timestamp = 3605090400000,
        until = null,
        title = "Update: Malevelon Creek",
        type = TransmissionType.Audio,
    ),
    TransmissionListEntry(
        id = "random-id-71266",
        timestamp = 3605065200000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
    ),
    TransmissionListEntry(
        id = "random-id-65406",
        timestamp = 3605058000000,
        until = 3605317200000,
        title = "Major Order: Troost",
        type = TransmissionType.Text,
    ),
    TransmissionListEntry(
        id = "random-id-54056",
        timestamp = 3604978800000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
    ),
)

private fun getTransmissionDetailsById(id: String): TransmissionDetails = when (id) {
    "random-id-83155" -> TransmissionDetails(
        id = "random-id-83155",
        timestamp = 3605090400000,
        until = null,
        title = "Update: Malevelon Creek",
        type = TransmissionType.Audio,
        content = """
            “This is Sergeant Jacobson, Helldiver Unit 7, transmitting my final message before succumbing to the relentless assault of the automatons in Malevelon Creek Sector.
            We've faced a ferocity unlike anything we've encountered before. The machines are relentless, cunning, and seemingly endless in number. Our ammunition is running critically low, and our defenses have been breached. The din of battle surrounds me as I dictate these words, and I fear our position is untenable.
            To my fellow soldiers: fight on with valor and unwavering determination. Our sacrifice here today may pave the way for future victories against the mechanized scourge. Remember, the spirit of resilience that binds us as comrades shall endure, even beyond the confines of this mortal coil.
            To my family: I carry your love and memories with me into the abyss. Know that I faced this final hour with courage and resolve, in service of a cause greater than myself.
            To Command: Our situation is dire, and I fear reinforcements may arrive too late. Transmit our coordinates to any surviving units and pray that they can hold the line where we could not.
            This will be my final communication. May our efforts not be in vain.
            Sergeant Jacobson, signing off.”
        """.trimIndent(),
        media = Media.AudioMedia(
            id = "random-media-id-12937",
            uri = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3",
            description = "12937",
            amplitude = null,
            // amplitude = listOf(0.1f, 0.6f, 0.4f, 0.45f, 0.5f, 0.7f, 0.3f, 0.35f, 0.3f, 0.2f, 0.1f, 0.6f, 0.8f, 0.7f, 0.75f, 0.3f, 0.37f),
        )
    )

    "random-id-71266" -> TransmissionDetails(
        id = "random-id-71266",
        timestamp = 3605065200000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
        content = "Super Earth Daily News with Trevor Noah.",
        media = Media.VideoMedia(
            id = "random-media-id-65405",
            uri = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            thumbnail = null,
            description = "65405",
        )
    )

    "random-id-65406" -> TransmissionDetails(
        id = "random-id-65406",
        timestamp = 3605058000000,
        until = 3605317200000,
        title = "Major Order: Troost",
        type = TransmissionType.Text,
        content = """
            We have discovered Automaton plans for something called “The Reclamation”.
            Capturing their deep-space comms array on Troost may reveal critical intel about their plans.

            Order Overview:
            - Liberate Troost.
              - TROOST.
        """.trimIndent(),
        media = null,
    )

    "random-id-54056" -> TransmissionDetails(
        id = "random-id-54056",
        timestamp = 3604978800000,
        until = null,
        title = "Super Earth Daily News",
        type = TransmissionType.Video,
        content = "Super Earth Daily News with Trevor Noah.",
        media = Media.VideoMedia(
            id = "random-media-id-28151",
            // .mov files are not supported by AVPlayer (iOS)
            uri = "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-lavf-56.36.100-aac-avc-main-1280x720.mkv",
            thumbnail = null,
            description = "28151",
        )
    )

    else -> TransmissionDetails(
        id = id,
        timestamp = 0,
        until = null,
        title = "Unknown Transmission",
        type = TransmissionType.Unknown,
        content = "Transmission could not be decoded.",
        media = null,
    )
}

private fun getTerminalOutput(): String = """
    SYSTEM: Booting Helldivers Remote version 0.1.0
    .
    .
    System booted successful
    Sending ENCRYPTED broadcast SIGNAL...
    Alert: ENCRYPTED broadcast SIGNAL SENT
    Waiting for Incoming transmissions...
    .
    .
    .
    Information: encrypted Transmission received
    Alert: Bug Breach Detected
    Requesting Eagle 500kg Bomb
    Request for Eagle 500kg Bomb accepted
    Estimated DROP TIME: 3 seconds
""".trimIndent()

private fun getPreferences() = listOf(
    AppPreference.SelectionPreference(
        id = PreferenceKeys.PK_DIALPAD_STYLE,
        availableValues = DialPadStyle.entries.map(DialPadStyle::toString),
        selectedValue = DialPadStyle.SwipePad.toString(),
    ),
    AppPreference.LinkPreference(
        id = PreferenceKeys.PK_SOURCE_CODE,
        url = "https://github.com/malliaridis/helldivers-remote",
    ),
    AppPreference.LinkPreference(
        id = PreferenceKeys.PK_REPORT_BUG,
        url = "https://github.com/malliaridis/helldivers-remote",
    ),
    AppPreference.DeepLinkPreference(
        id = PreferenceKeys.PK_LICENSES,
        deepLink = "helldivers://remote/licenses",
    ),
)
