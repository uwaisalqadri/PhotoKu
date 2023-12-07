package com.devfestmks.photoku

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val appPlatform: String = "ios"
}

actual fun getPlatform(): Platform = IOSPlatform()