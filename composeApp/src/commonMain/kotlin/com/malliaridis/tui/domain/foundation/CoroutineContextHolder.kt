package com.malliaridis.tui.domain.foundation

import kotlin.coroutines.CoroutineContext

interface CoroutineContextHolder {

    val mainContext: CoroutineContext

    val ioContext: CoroutineContext
}
