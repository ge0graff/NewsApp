package com.example.newsapp.ui.fragments

import androidx.lifecycle.*
import com.example.newsapp.domain.repository.DataBaseRepository

class NewsFragmentViewModel(private val repository: DataBaseRepository): ViewModel() {

    val newsList = repository.getData()
}