package com.example.newsapp.ui.fragments

import androidx.lifecycle.*
import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.DataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragmentViewModel(private val repository: DataBaseRepository): ViewModel() {

    val newsList = repository.getData()
}