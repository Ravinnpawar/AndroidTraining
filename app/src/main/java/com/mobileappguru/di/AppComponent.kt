package com.mobileappguru.di

import com.mobileappguru.androidtraining.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}