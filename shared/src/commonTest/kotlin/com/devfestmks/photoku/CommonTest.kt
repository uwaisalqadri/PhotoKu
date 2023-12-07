package com.devfestmks.photoku

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.koin.test.KoinTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class CommonTest: KoinTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
    }

    @AfterTest
    fun tearDown() {
    }
}