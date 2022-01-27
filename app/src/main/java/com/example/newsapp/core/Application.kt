package com.example.newsapp.core

import android.app.Application
import com.example.newsapp.BuildConfig
import com.example.newsapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@Application)
            modules(
                listOf(
                    networkModule,
                    newsApiRepositoryModule,
                    newsDataBaseDaoModule,
                    splashActivityViewModelModule,
                    dataBaseRepositoryModule,
                    newsFragmentViewModelModule,
                )
            )
        }
    }

}