package com.npl.kointodoapp.app

import android.app.Application
import com.npl.kointodoapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TodoApplication)
            modules(appModule)
        }
    }
}