package com.malliaridis.tui.domain.foundation

import com.malliaridis.tui.model.SuperEarthShip
import kotlinx.datetime.Instant

sealed interface ConnectionState {

    data class Connected(
        val ses: SuperEarthShip,
        val establishedAt: Instant,
    ) : ConnectionState

    data object Disconnected : ConnectionState
}
