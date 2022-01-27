package com.example.newsapp.di

import com.example.newsapp.ui.activities.SplashActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashActivityViewModelModule = module {
    viewModel {
        SplashActivityViewModel(provideNewsApiRepository(get(), get()), provideDataBaseRepository(get()))
    }

}