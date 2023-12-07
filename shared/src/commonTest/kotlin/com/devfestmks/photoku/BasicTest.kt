package com.devfestmks.photoku

import kotlin.test.Test
import kotlin.test.assertTrue

class BasicTest {
    @Test
    fun testGetPlatform_isNotEmpty() {
        assertTrue {
            getPlatform().name.isNotEmpty()
        }
    }

    @Test
    fun testGetPlatform_isAndroid() {
        assertTrue {
            getPlatform().appPlatform == "android"
        }
    }

    @Test
    fun testGetPlatform_isIOS() {
        assertTrue {
            getPlatform().appPlatform == "ios"
        }
    }

}