package com.malliaridis.tui.domain.configuration.integration

import com.malliaridis.tui.domain.configuration.PreferencesComponent
import com.malliaridis.tui.domain.configuration.PreferencesComponent.Model
import com.malliaridis.tui.domain.foundation.AppComponentContext
import com.malliaridis.tui.model.AppPreference
import com.malliaridis.tui.model.PreferenceCollections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * @param collectionKey The preference collection key for loading a predefined preference collection.
 */
class DefaultPreferencesComponent(
    componentContext: AppComponentContext,
    private val collectionKey: String,
) : PreferencesComponent, AppComponentContext by componentContext {

    // TODO Replace mutable state flow instance with preference store state
    override val models: StateFlow<Model> = MutableStateFlow(
        Model(values = PreferenceCollections.getCollectionById(collectionKey))
    )

    override fun onSelectPreference(preference: AppPreference<*>?) {
        TODO("Not yet implemented")
    }

    override fun onUpdatePreference(preferenceId: String, value: Any?) {
        TODO("Not yet implemented")
    }

    override fun onResetPreferenceById(preferenceId: String) {
        TODO("Not yet implemented")
    }

    override fun <V> get(preferenceId: String): V {
        return models.value.values.first { it.id == preferenceId }.value as V
    }
}
