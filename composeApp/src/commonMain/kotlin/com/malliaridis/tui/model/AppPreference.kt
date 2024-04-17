package com.malliaridis.tui.model

import com.malliaridis.tui.ui.components.stratagems.DialPadStyle
import kotlinx.serialization.Serializable

/**
 * App preference classes provide app configuration options and settings generation.
 *
 * Currently only the needed types are added, but this can be expanded in future for additional preferences.
 */
@Serializable
sealed interface AppPreference<T> {

    val id: String

    val value: T

    val defaultValue: T

    val isDefault: Boolean
        get() = value == defaultValue

    @Serializable
    data class IntPreference(
        override val id: String,
        override val value: Int,
        override val defaultValue: Int,
        val minValue: Int = Int.MIN_VALUE,
        val maxValue: Int = Int.MAX_VALUE,
    ) : AppPreference<Int>

    @Serializable
    data class LongPreference(
        override val id: String,
        override val value: Long,
        override val defaultValue: Long,
        val minValue: Long = Long.MIN_VALUE,
        val maxValue: Long = Long.MAX_VALUE,
    ) : AppPreference<Long>

    @Serializable
    data class FloatPreference(
        override val id: String,
        override val value: Float,
        override val defaultValue: Float,
        val minValue: Float = Float.MIN_VALUE,
        val maxValue: Float = Float.MAX_VALUE,
    ) : AppPreference<Float>

    @Serializable
    data class DoublePreference(
        override val id: String,
        override val value: Double,
        override val defaultValue: Double,
        val minValue: Double = Double.MIN_VALUE,
        val maxValue: Double = Double.MAX_VALUE,
    ) : AppPreference<Double>

    @Serializable
    data class StringPreference(
        override val id: String,
        override val value: String,
        override val defaultValue: String,
    ) : AppPreference<String>

    @Serializable
    data class EnumPreference<T : Enum<T>>(
        override val id: String,
        override val value: T,
        override val defaultValue: T,
    ) : AppPreference<T>

    @Serializable
    data class ListPreference<T>(
        override val id: String,
        override val value: T,
        override val defaultValue: T,
        val validValues: List<T>,
    ) : AppPreference<T>

    @Serializable
    data class MultiListPreference<T : List<T>>(
        override val id: String,
        override val value: T,
        override val defaultValue: T,
        val validValues: T,
    ) : AppPreference<T>

    /**
     * The link preference holds simply a URI, allowing preference visualizations to redirect users to a website.
     * This is useful when a link like for Privacy policies should be included in the settings and redirect the user
     * to a browser website.
     *
     * To better distinguish between URLs that may redirect to a browser and deep links that redirect to another place
     * of the app, [LinkPreference] and [DeepLinkPreference] are used.
     */
    @Serializable
    data class LinkPreference(
        override val id: String,
        override val value: String,
        override val defaultValue: String,
    ) : AppPreference<String>

    /**
     * The deep link preference holds simply a URI, allowing preference visualizations to redirect users via deep links.
     *
     * To better distinguish between URLs that may redirect to a browser and deep links that redirect to another place
     * of the app, [LinkPreference] and [DeepLinkPreference] are used.
     */
    @Serializable
    data class DeepLinkPreference(
        override val id: String,
        override val value: String,
        override val defaultValue: String,
    ) : AppPreference<String>
}

object PreferenceKeys {
    const val PK_DIALPAD_STYLE = "pk_dialpad_style"
    const val PK_SOURCE_CODE = "pk_access_source_code"
    const val PK_REPORT_BUG = "pk_report_bug"
    const val PK_LICENSES = "pk_licenses"
}

object PreferenceCollectionKeys {
    const val PCK_SETTINGS = "settings"
}

object PreferenceCollections {

    /**
     * Function that provides predefined preference collections with default values. If the collection key is unknown
     * an empty list is returned.
     *
     * Note that the preferences returned do not load the actual preference value set by the user, but use the
     * default value instead. It is up to the caller to retrieve the actual values from a store.
     */
    fun getCollectionById(collectionKey: String) = when (collectionKey) {
        PreferenceCollectionKeys.PCK_SETTINGS -> listOf(
            AppPreference.ListPreference(
                id = PreferenceKeys.PK_DIALPAD_STYLE,
                defaultValue = DialPadStyle.SwipePad,
                value = DialPadStyle.SwipePad,
                validValues = DialPadStyle.entries,
            ),
            AppPreference.LinkPreference(
                id = PreferenceKeys.PK_SOURCE_CODE,
                value = "https://github.com/malliaridis/tactical-user-interface/",
                defaultValue = "https://github.com/malliaridis/tactical-user-interface/",
            ),
            AppPreference.LinkPreference(
                id = PreferenceKeys.PK_REPORT_BUG,
                value = "https://github.com/malliaridis/tactical-user-interface/issues/new",
                defaultValue = "https://github.com/malliaridis/tactical-user-interface/issues/new",
            ),
            AppPreference.DeepLinkPreference(
                id = PreferenceKeys.PK_LICENSES,
                value = "tui://licenses",
                defaultValue = "tui://licenses",
            ),
        )

        else -> emptyList()
    }
}
