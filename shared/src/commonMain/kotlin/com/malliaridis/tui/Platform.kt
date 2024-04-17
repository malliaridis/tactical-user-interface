package com.malliaridis.tui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform