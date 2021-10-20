package com.example.testproject

import android.app.Application
import com.example.testproject.module.commonModule
import com.example.testproject.module.repoModule
import com.example.testproject.module.usecaseModule
import com.example.testproject.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(repoModule, commonModule, usecaseModule, viewModelModule)
        }
    }
}