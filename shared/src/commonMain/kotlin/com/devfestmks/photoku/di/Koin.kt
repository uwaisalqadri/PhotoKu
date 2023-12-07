package com.devfestmks.photoku.di

import com.devfestmks.photoku.di.feature.coreModule
import com.devfestmks.photoku.di.feature.photoModule
import com.devfestmks.photoku.repository.PhotoRepository
import com.devfestmks.photoku.utils.resourceReaderModule
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            photoModule,
            coreModule,
            resourceReaderModule()
        )
    }
}

// Koin utilities for iOS injection
fun KoinApplication.Companion.start(): KoinApplication = initKoin {}

val Koin.photoRepository: PhotoRepository
    get() = get()