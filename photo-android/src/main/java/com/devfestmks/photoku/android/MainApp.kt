package com.devfestmks.photoku.android

import android.app.Application
import com.devfestmks.photoku.android.di.featureModule
import com.devfestmks.photoku.di.initKoin
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MainApp)
            modules(featureModule)
        }
    }
}