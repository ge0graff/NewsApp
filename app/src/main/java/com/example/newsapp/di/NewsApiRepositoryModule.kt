package com.example.newsapp.di

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.data.repositories.NewsApiRepositoryImpl
import org.koin.dsl.module

val newsApiRepositoryModule = module {

    single { provideNewsApiRepository(get(), get()) }

}

fun provideNewsApiRepository(api: NewsApiService, dao: NewsDataBaseDao): NewsApiRepositoryImpl {
    return NewsApiRepositoryImpl(api, dao)
}