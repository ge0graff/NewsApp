package com.example.newsapp.di

import com.example.newsapp.ui.activities.SplashActivityViewModel
import com.example.newsapp.ui.fragments.NewsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsFragmentViewModelModule = module {
    viewModel {
        NewsFragmentViewModel(provideDataBaseRepository(get()))
    }

}