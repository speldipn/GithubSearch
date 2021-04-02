package com.example.githubsearch

import android.app.Application
import com.example.githubsearch.module.modules
import org.koin.android.ext.android.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }
}