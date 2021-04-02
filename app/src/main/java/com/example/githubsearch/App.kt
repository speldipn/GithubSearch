package com.example.githubsearch

import android.app.Application
import com.example.githubsearch.module.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(modules)
        }

    }
}