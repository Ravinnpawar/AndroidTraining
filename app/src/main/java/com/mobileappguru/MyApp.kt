package com.mobileappguru

import android.app.Application
import com.mobileappguru.di.AppComponent
import com.mobileappguru.di.AppModule
import com.mobileappguru.di.DaggerAppComponent

class MyApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}