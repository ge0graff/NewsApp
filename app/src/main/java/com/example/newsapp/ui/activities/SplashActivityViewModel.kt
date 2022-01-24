package com.example.newsapp.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.NewsApiRepository
import kotlinx.coroutines.launch

class SplashActivityViewModel(private val repository: NewsApiRepository): ViewModel() {

    fun getInsertNews() = viewModelScope.launch{
        repository.getInsertNews()
    }
}