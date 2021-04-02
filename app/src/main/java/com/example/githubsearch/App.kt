package com.example.githubsearch

import android.app.Application
import com.example.githubsearch.module.modules
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this@App)

        startKoin {
            androidContext(this@App)
            modules(modules)
        }

    }
}