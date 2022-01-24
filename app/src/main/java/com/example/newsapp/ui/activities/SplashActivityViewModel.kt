package com.example.newsapp.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newsapp.domain.repository.NewsApiRepository

class SplashActivityViewModel(private val repository: NewsApiRepository): ViewModel() {

    fun getInsertNews() = liveData {
        emit(repository.loadDataToDatabase())
    }
}