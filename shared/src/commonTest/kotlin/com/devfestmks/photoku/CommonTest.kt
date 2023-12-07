package com.devfestmks.photoku

import com.devfestmks.photoku.di.feature.coreModule
import com.devfestmks.photoku.di.feature.photoModule
import com.devfestmks.photoku.presentation.PhotoEvent
import com.devfestmks.photoku.presentation.PhotoState
import com.devfestmks.photoku.presentation.PhotoViewModel
import com.devfestmks.photoku.source.model.Photo
import com.devfestmks.photoku.utils.ResourceReader
import com.devfestmks.photoku.utils.resourceReaderModule
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.coEvery
import io.mockative.coVerify
import io.mockative.every
import io.mockative.mock
import io.mockative.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.Json
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.assertEquals

class CommonTest: KoinTest {
    private val resourceReader: ResourceReader by inject()
    private val json: Json by inject()

    private val viewModel = PhotoViewModel()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())

        startKoin {
            modules(
                photoModule,
                coreModule,
                resourceReaderModule()
            )
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun test_GetResourcesSuccess() = runTest {
        assertTrue {
            resourceReader.readResource("photos.json").isNotEmpty()
        }
    }

    @Test
    fun test_JsonSerialized() = runTest {
        val jsonFile = resourceReader.readResource("photos.json")
        val result = json.decodeFromString<List<Photo>>(jsonFile).first().name
        assertEquals("City Street", result, "JSON is Serialized")
    }

    @Test
    fun test_viewModel_PhotoEvent_GetPhotos() = runTest {
        val photoState = PhotoState(photos = listOf(Photo(imageUrl = "url", name = "Sky")))
        viewModel.onTriggerEvent(PhotoEvent.GetPhotos)

        backgroundScope.launch {
            assertEquals(photoState, viewModel.state.value)
        }
    }

}