package com.devfestmks.photoku

interface Platform {
    val name: String
    val appPlatform: String
}

expect fun getPlatform(): Platform