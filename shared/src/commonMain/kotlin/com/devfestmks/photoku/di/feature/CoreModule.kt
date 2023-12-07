package com.devfestmks.photoku.di.feature

import kotlinx.serialization.json.Json
import org.koin.dsl.module

val coreModule = module {
    single { createJson() }
}

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}