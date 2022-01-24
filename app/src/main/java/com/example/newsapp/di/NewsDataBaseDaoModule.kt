package com.example.newsapp.di

import com.example.newsapp.data.dataBase.NewsDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val newsDataBaseDaoModule = module {
    single { NewsDataBase.getInstance(androidContext()).NewsDataBaseDao() }
}
