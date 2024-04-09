package com.chipmunksmedia.helldivers.remote.ui.utils

import androidx.compose.runtime.Composable
import com.chipmunksmedia.helldivers.remote.model.AppPreference
import com.chipmunksmedia.helldivers.remote.model.Direction
import com.chipmunksmedia.helldivers.remote.model.PreferenceKeys
import com.chipmunksmedia.helldivers.remote.model.TransmissionType
import com.chipmunksmedia.helldivers.remote.ui.components.stratagems.DialPadStyle
import helldiversremote.composeapp.generated.resources.Res
import helldiversremote.composeapp.generated.resources.direction_center
import helldiversremote.composeapp.generated.resources.direction_down
import helldiversremote.composeapp.generated.resources.direction_left
import helldiversremote.composeapp.generated.resources.direction_none
import helldiversremote.composeapp.generated.resources.direction_right
import helldiversremote.composeapp.generated.resources.direction_up
import helldiversremote.composeapp.generated.resources.dp_style_circular
import helldiversremote.composeapp.generated.resources.dp_style_rectangular
import helldiversremote.composeapp.generated.resources.dp_style_swipe
import helldiversremote.composeapp.generated.resources.pk_change_dial_pad_style
import helldiversremote.composeapp.generated.resources.pk_licenses
import helldiversremote.composeapp.generated.resources.pk_report_bug
import helldiversremote.composeapp.generated.resources.pk_source_code
import helldiversremote.composeapp.generated.resources.pk_unknown
import helldiversremote.composeapp.generated.resources.st_a_ac8
import helldiversremote.composeapp.generated.resources.st_a_arc3
import helldiversremote.composeapp.generated.resources.st_a_g16
import helldiversremote.composeapp.generated.resources.st_a_m12
import helldiversremote.composeapp.generated.resources.st_a_m23
import helldiversremote.composeapp.generated.resources.st_a_mg43
import helldiversremote.composeapp.generated.resources.st_a_mls4x
import helldiversremote.composeapp.generated.resources.st_a_mls_4x
import helldiversremote.composeapp.generated.resources.st_ac8
import helldiversremote.composeapp.generated.resources.st_apw1
import helldiversremote.composeapp.generated.resources.st_arc3
import helldiversremote.composeapp.generated.resources.st_ax_ar23
import helldiversremote.composeapp.generated.resources.st_ax_las5
import helldiversremote.composeapp.generated.resources.st_b1
import helldiversremote.composeapp.generated.resources.st_e_mg101
import helldiversremote.composeapp.generated.resources.st_eagle_110mm
import helldiversremote.composeapp.generated.resources.st_eagle_500kg
import helldiversremote.composeapp.generated.resources.st_eagle_airstrike
import helldiversremote.composeapp.generated.resources.st_eagle_cluster
import helldiversremote.composeapp.generated.resources.st_eagle_napalm
import helldiversremote.composeapp.generated.resources.st_eagle_rearm
import helldiversremote.composeapp.generated.resources.st_eagle_smoke
import helldiversremote.composeapp.generated.resources.st_eagle_strafing
import helldiversremote.composeapp.generated.resources.st_eat17
import helldiversremote.composeapp.generated.resources.st_exo45
import helldiversremote.composeapp.generated.resources.st_faf14
import helldiversremote.composeapp.generated.resources.st_flam40
import helldiversremote.composeapp.generated.resources.st_fx12
import helldiversremote.composeapp.generated.resources.st_gl21
import helldiversremote.composeapp.generated.resources.st_gr8
import helldiversremote.composeapp.generated.resources.st_hellbomb
import helldiversremote.composeapp.generated.resources.st_las98
import helldiversremote.composeapp.generated.resources.st_lift850
import helldiversremote.composeapp.generated.resources.st_m105
import helldiversremote.composeapp.generated.resources.st_md6
import helldiversremote.composeapp.generated.resources.st_md_i4
import helldiversremote.composeapp.generated.resources.st_mdi4
import helldiversremote.composeapp.generated.resources.st_mg43
import helldiversremote.composeapp.generated.resources.st_orbital_120mm
import helldiversremote.composeapp.generated.resources.st_orbital_380mm
import helldiversremote.composeapp.generated.resources.st_orbital_airbust
import helldiversremote.composeapp.generated.resources.st_orbital_ems
import helldiversremote.composeapp.generated.resources.st_orbital_gas
import helldiversremote.composeapp.generated.resources.st_orbital_gatling
import helldiversremote.composeapp.generated.resources.st_orbital_laser
import helldiversremote.composeapp.generated.resources.st_orbital_precision
import helldiversremote.composeapp.generated.resources.st_orbital_railcannon
import helldiversremote.composeapp.generated.resources.st_orbital_smoke
import helldiversremote.composeapp.generated.resources.st_orbital_walking
import helldiversremote.composeapp.generated.resources.st_reinforce
import helldiversremote.composeapp.generated.resources.st_resupply
import helldiversremote.composeapp.generated.resources.st_rs422
import helldiversremote.composeapp.generated.resources.st_seismic_probe
import helldiversremote.composeapp.generated.resources.st_sh20
import helldiversremote.composeapp.generated.resources.st_sh32
import helldiversremote.composeapp.generated.resources.st_sos_beacon
import helldiversremote.composeapp.generated.resources.st_sssd_delivery
import helldiversremote.composeapp.generated.resources.st_tm_type_audio
import helldiversremote.composeapp.generated.resources.st_tm_type_text
import helldiversremote.composeapp.generated.resources.st_tm_type_unknown
import helldiversremote.composeapp.generated.resources.st_tm_type_video
import helldiversremote.composeapp.generated.resources.st_unknown
import helldiversremote.composeapp.generated.resources.st_upload_data
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getDirectionPainter(direction: Direction) = painterResource(getDirectionDrawable(direction))

@OptIn(ExperimentalResourceApi::class)
internal fun getDirectionDrawable(direction: Direction) = when (direction) {
    Direction.Up -> Res.drawable.direction_up
    Direction.Down -> Res.drawable.direction_down
    Direction.Left -> Res.drawable.direction_left
    Direction.Right -> Res.drawable.direction_right
    else -> error("Invalid direction")
    //Direction.Center -> Res.drawable.direction_center
    //Direction.None -> Res.drawable.direction_unknown
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getDirectionDisplayName(direction: Direction) = stringResource(getDirectionStringResource(direction))

@OptIn(ExperimentalResourceApi::class)
internal fun getDirectionStringResource(direction: Direction) = when (direction) {
    Direction.Up -> Res.string.direction_up
    Direction.Down -> Res.string.direction_down
    Direction.Left -> Res.string.direction_left
    Direction.Right -> Res.string.direction_right
    Direction.Center -> Res.string.direction_center
    Direction.None -> Res.string.direction_none
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getStratagemDisplayName(id: String) = stringResource(getStratagemStringResource(id))

@OptIn(ExperimentalResourceApi::class)
internal fun getStratagemStringResource(id: String) = when (id) {
    "st_eagle_rearm" -> Res.string.st_eagle_rearm
    "st_hellbomb" -> Res.string.st_hellbomb
    "st_reinforce" -> Res.string.st_reinforce
    "st_seismic_probe" -> Res.string.st_seismic_probe
    "st_resupply" -> Res.string.st_resupply
    "st_sos_beacon" -> Res.string.st_sos_beacon
    "st_sssd_delivery" -> Res.string.st_sssd_delivery
    "st_upload_data" -> Res.string.st_upload_data
    "st_ac8" -> Res.string.st_ac8
    "st_apw1" -> Res.string.st_apw1
    "st_arc3" -> Res.string.st_arc3
    "st_eat17" -> Res.string.st_eat17
    "st_faf14" -> Res.string.st_faf14
    "st_flam40" -> Res.string.st_flam40
    "st_gl21" -> Res.string.st_gl21
    "st_gr8" -> Res.string.st_gr8
    "st_las98" -> Res.string.st_las98
    "st_mg43" -> Res.string.st_mg43
    "st_m105" -> Res.string.st_m105
    "st_rs422" -> Res.string.st_rs422
    "st_sh20" -> Res.string.st_sh20
    "st_sh32" -> Res.string.st_sh32
    "st_ax_las5" -> Res.string.st_ax_las5
    "st_ax_ar23" -> Res.string.st_ax_ar23
    "st_b1" -> Res.string.st_b1
    "st_lift850" -> Res.string.st_lift850
    "st_exo45" -> Res.string.st_exo45
    "st_a_ac8" -> Res.string.st_a_ac8
    "st_a_arc3" -> Res.string.st_a_arc3
    "st_a_g16" -> Res.string.st_a_g16
    "st_a_m12" -> Res.string.st_a_m12
    "st_a_m23" -> Res.string.st_a_m23
    "st_a_mg43" -> Res.string.st_a_mg43
    "st_a_mls4x" -> Res.string.st_a_mls4x
    "st_e_mg101" -> Res.string.st_e_mg101
    "st_fx12" -> Res.string.st_fx12
    "st_md6" -> Res.string.st_md6
    "st_mdi4" -> Res.string.st_mdi4
    "st_orbital_airbust" -> Res.string.st_orbital_airbust
    "st_orbital_ems" -> Res.string.st_orbital_ems
    "st_orbital_gas" -> Res.string.st_orbital_gas
    "st_orbital_gatling" -> Res.string.st_orbital_gatling
    "st_orbital_laser" -> Res.string.st_orbital_laser
    "st_orbital_precision" -> Res.string.st_orbital_precision
    "st_orbital_railcannon" -> Res.string.st_orbital_railcannon
    "st_orbital_smoke" -> Res.string.st_orbital_smoke
    "st_orbital_walking" -> Res.string.st_orbital_walking
    "st_orbital_120mm" -> Res.string.st_orbital_120mm
    "st_orbital_380mm" -> Res.string.st_orbital_380mm
    "st_eagle_airstrike" -> Res.string.st_eagle_airstrike
    "st_eagle_cluster" -> Res.string.st_eagle_cluster
    "st_eagle_napalm" -> Res.string.st_eagle_napalm
    "st_eagle_smoke" -> Res.string.st_eagle_smoke
    "st_eagle_strafing" -> Res.string.st_eagle_strafing
    "st_eagle_110mm" -> Res.string.st_eagle_110mm
    "st_eagle_500kg" -> Res.string.st_eagle_500kg
    else -> Res.string.st_unknown
}

@OptIn(ExperimentalResourceApi::class)
internal fun getStratagemDrawableResource(id: String) = when (id) {
    "st_eagle_rearm" -> Res.drawable.st_eagle_rearm
    "st_hellbomb" -> Res.drawable.st_hellbomb
    "st_reinforce" -> Res.drawable.st_reinforce
    "st_seismic_probe" -> Res.drawable.st_seismic_probe
    "st_resupply" -> Res.drawable.st_resupply
    "st_sos_beacon" -> Res.drawable.st_sos_beacon
    "st_sssd_delivery" -> Res.drawable.st_sssd_delivery
    "st_upload_data" -> Res.drawable.st_upload_data
    "st_ac8" -> Res.drawable.st_ac8
    "st_apw1" -> Res.drawable.st_apw1
    "st_arc3" -> Res.drawable.st_arc3
    "st_eat17" -> Res.drawable.st_eat17
    "st_faf14" -> Res.drawable.st_faf14
    "st_flam40" -> Res.drawable.st_flam40
    "st_gl21" -> Res.drawable.st_gl21
    "st_gr8" -> Res.drawable.st_gr8
    "st_las98" -> Res.drawable.st_las98
    "st_mg43" -> Res.drawable.st_mg43
    "st_m105" -> Res.drawable.st_m105
    "st_rs422" -> Res.drawable.st_rs422
    "st_sh20" -> Res.drawable.st_sh20
    "st_sh32" -> Res.drawable.st_sh32
    "st_ax_las5" -> Res.drawable.st_ax_las5
    "st_ax_ar23" -> Res.drawable.st_ax_ar23
    "st_b1" -> Res.drawable.st_b1
    "st_lift850" -> Res.drawable.st_lift850
    "st_exo45" -> Res.drawable.st_exo45
    "st_a_ac8" -> Res.drawable.st_a_ac8
    "st_a_arc3" -> Res.drawable.st_a_arc3
    "st_a_g16" -> Res.drawable.st_a_g16
    "st_a_m12" -> Res.drawable.st_a_m12
    "st_a_m23" -> Res.drawable.st_a_m23
    "st_a_mg43" -> Res.drawable.st_a_mg43
    "st_a_mls4x" -> Res.drawable.st_a_mls_4x
    "st_e_mg101" -> Res.drawable.st_e_mg101
    "st_fx12" -> Res.drawable.st_fx12
    "st_md6" -> Res.drawable.st_md6
    "st_mdi4" -> Res.drawable.st_md_i4
    "st_orbital_airbust" -> Res.drawable.st_orbital_airbust
    "st_orbital_ems" -> Res.drawable.st_orbital_ems
    "st_orbital_gas" -> Res.drawable.st_orbital_gas
    "st_orbital_gatling" -> Res.drawable.st_orbital_gatling
    "st_orbital_laser" -> Res.drawable.st_orbital_laser
    "st_orbital_precision" -> Res.drawable.st_orbital_precision
    "st_orbital_railcannon" -> Res.drawable.st_orbital_railcannon
    "st_orbital_smoke" -> Res.drawable.st_orbital_smoke
    "st_orbital_walking" -> Res.drawable.st_orbital_walking
    "st_orbital_120mm" -> Res.drawable.st_orbital_120mm
    "st_orbital_380mm" -> Res.drawable.st_orbital_380mm
    "st_eagle_airstrike" -> Res.drawable.st_eagle_airstrike
    "st_eagle_cluster" -> Res.drawable.st_eagle_cluster
    "st_eagle_napalm" -> Res.drawable.st_eagle_napalm
    "st_eagle_smoke" -> Res.drawable.st_eagle_smoke
    "st_eagle_strafing" -> Res.drawable.st_eagle_strafing
    "st_eagle_110mm" -> Res.drawable.st_eagle_110mm
    "st_eagle_500kg" -> Res.drawable.st_eagle_500kg
    else -> error("Unknown stratagem") // TODO Add icon for unknown stratagem "Res.drawable.st_unknown"
}


/**
 * Mapper function that maps transmission types to subtitle texts.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun TransmissionType.toSubtitle(): String = when (this) {
    TransmissionType.Unknown -> stringResource(Res.string.st_tm_type_unknown)
    TransmissionType.Audio -> stringResource(Res.string.st_tm_type_audio)
    TransmissionType.Text -> stringResource(Res.string.st_tm_type_text)
    TransmissionType.Video -> stringResource(Res.string.st_tm_type_video)
}


/**
 * Mapper function that translates milliseconds since epoch to "Ends in: `days`D `hours`H" format.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun Long.toDiffStringSince(start: Long): String = "1D 23H" // TODO Implement me

/**
 * Mapper function that translates milliseconds since epoch to "YYYYMMDDHHmm" format.
 */
internal val Long.asDateTimeValue: String
    get() = "208403280900" // TODO Implement me

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppPreference<*>.getDisplayName(): String = stringResource(
    when (id) {
        PreferenceKeys.PK_DIALPAD_STYLE -> Res.string.pk_change_dial_pad_style
        PreferenceKeys.PK_SOURCE_CODE -> Res.string.pk_source_code
        PreferenceKeys.PK_REPORT_BUG -> Res.string.pk_report_bug
        PreferenceKeys.PK_LICENSES -> Res.string.pk_licenses
        else -> Res.string.pk_unknown
    }
)

@Composable
@OptIn(ExperimentalResourceApi::class)
fun getPreferenceValueDisplayName(value: String): String = when (value) {
    DialPadStyle.SwipePad.toString() -> stringResource(Res.string.dp_style_swipe)
    DialPadStyle.Circular.toString() -> stringResource(Res.string.dp_style_circular)
    DialPadStyle.Rectangular.toString() -> stringResource(Res.string.dp_style_rectangular)
    else -> value
}
