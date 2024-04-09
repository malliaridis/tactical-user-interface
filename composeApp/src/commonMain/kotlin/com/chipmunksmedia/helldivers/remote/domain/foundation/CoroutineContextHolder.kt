package com.chipmunksmedia.helldivers.remote.domain.foundation

import kotlin.coroutines.CoroutineContext

interface CoroutineContextHolder {

    val mainContext: CoroutineContext

    val ioContext: CoroutineContext
}
