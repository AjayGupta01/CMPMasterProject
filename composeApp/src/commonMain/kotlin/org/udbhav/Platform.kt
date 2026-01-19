package org.udbhav

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform