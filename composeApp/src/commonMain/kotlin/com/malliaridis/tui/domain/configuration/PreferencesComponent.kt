package com.malliaridis.tui.domain.configuration

import com.malliaridis.tui.model.AppPreference
import kotlinx.coroutines.flow.StateFlow

/**
 * The preferences component manages the user's preferences.
 */
interface PreferencesComponent {

    val models: StateFlow<Model>

    /**
     * Function for handling preference selections.
     */
    fun onSelectPreference(preference: AppPreference<*>?)

    /**
     * Function for handling preference update requests.
     *
     * This does not clear / resets the preference if [AppPreference.value] is set to [AppPreference.defaultValue]. See for that
     * [onResetPreferenceById].
     *
     * @param preferenceId ID of the preference to update.
     * @param value The new value of the preference.
     */
    fun onUpdatePreference(preferenceId: String, value: Any?)

    /**
     * Function that resets the value of a preference with the given ID.
     *
     * @param preferenceId The ID of the preference to reset.
     */
    fun onResetPreferenceById(preferenceId: String)

    /**
     * Returns the value of the preference with the given ID.
     *
     * @param preferenceId The ID from which the value should be fetched.
     * @return The currently loaded value.
     */
    fun <V> get(preferenceId: String): V

    /**
     * Data class that represents the state of [PreferencesComponent].
     *
     * @property values A list of the currently active preferences as key-value pairs.
     * @property isLoading Whether the preferences are being loaded.
     * @property focused The focused preference, if any.
     */
    data class Model(
        val values: List<AppPreference<*>> = emptyList(),
        val isLoading: Boolean = false,
        val focused: AppPreference<*>? = null,
    )
}
