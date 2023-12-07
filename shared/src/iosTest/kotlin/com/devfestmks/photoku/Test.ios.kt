package com.devfestmks.photoku

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(getPlatform().appPlatform.contains("ios"), "Check iOS is mentioned")
    }
}