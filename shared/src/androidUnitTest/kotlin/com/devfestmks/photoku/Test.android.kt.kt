package com.devfestmks.photoku

import kotlin.test.Test
import kotlin.test.assertTrue

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue(getPlatform().appPlatform.contains("android"), "Check Android is mentioned")
    }
}