package com.example.newsapp.di

import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.data.repositories.DataBaseRepositoryImpl
import org.koin.dsl.module

val dataBaseRepositoryModule = module {

    single { provideDataBaseRepository(get()) }

}

fun provideDataBaseRepository(dao: NewsDataBaseDao): DataBaseRepositoryImpl {
    return DataBaseRepositoryImpl(dao)
}