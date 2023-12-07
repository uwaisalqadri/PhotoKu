package com.devfestmks.photoku.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
        )
    }
}

// Koin utilities for iOS injection
fun KoinApplication.Companion.start(): KoinApplication = initKoin {}