package com.chipmunksmedia.helldivers.remote.domain.foundation

import kotlinx.coroutines.flow.StateFlow

interface ConnectionStateHolder {

    /**
     * The connection state as a state flow that can be consumed.
     */
    val connectionStateFlow: StateFlow<ConnectionState>
}
