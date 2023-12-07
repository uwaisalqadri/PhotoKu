package com.devfestmks.photoku

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val appPlatform: String = "android"
}

actual fun getPlatform(): Platform = AndroidPlatform()