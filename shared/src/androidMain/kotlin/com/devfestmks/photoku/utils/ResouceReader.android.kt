package com.devfestmks.photoku.utils

import android.content.Context
import org.koin.dsl.module
import java.io.InputStreamReader

class AssetResourceReader : ResourceReader {
    override fun readResource(name: String): String {
        // TODO: Catch Android-only exceptions and map them to common ones.
        return javaClass.classLoader?.getResourceAsStream(name).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }
    }
}

actual fun resourceReaderModule() = module {
    single<ResourceReader> { AssetResourceReader() }
}