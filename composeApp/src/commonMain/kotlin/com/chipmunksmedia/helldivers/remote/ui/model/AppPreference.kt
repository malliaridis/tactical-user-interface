package com.chipmunksmedia.helldivers.remote.ui.model

/**
 * App preference classes provide app configuration options and settings generation.
 *
 * Currently only the needed types are added, but this can be expanded in future for additional preferences.
 */
sealed interface AppPreference {

    val id: String

    data class SelectionPreference(
        override val id: String,
        val availableValues: List<String>,
        val selectedValue: String,
    ) : AppPreference

    data class LinkPreference(
        override val id: String,
        val url: String,
    ) : AppPreference

    data class DeepLinkPreference(
        override val id: String,
        val deepLink: String,
    ) : AppPreference
}

object PreferenceKeys {
    const val PK_DIALPAD_STYLE = "pk_dialpad_style"
    const val PK_SOURCE_CODE = "pk_access_source_code"
    const val PK_REPORT_BUG = "pk_report_bug"
    const val PK_LICENSES = "pk_licenses"
}