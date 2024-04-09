package com.chipmunksmedia.helldivers.remote.domain.foundation

import com.chipmunksmedia.helldivers.remote.model.SuperEarthShip
import kotlinx.datetime.Instant

sealed interface ConnectionState {

    data class Connected(
        val ses: SuperEarthShip,
        val establishedAt: Instant,
    ) : ConnectionState

    data object Disconnected : ConnectionState
}
