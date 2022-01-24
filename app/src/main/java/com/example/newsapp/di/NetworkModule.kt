package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
    single { provideApiService(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): NewsApiService {
    return retrofit.create(NewsApiService::class.java)
}

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient()
        .newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        )
        .build()