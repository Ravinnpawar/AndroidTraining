package com.mobileappguru.di

import android.content.Context
import com.mobileappguru.data.MyDataParser
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMyDataParser(context: Context): MyDataParser {
        return MyDataParser(context)
    }
}