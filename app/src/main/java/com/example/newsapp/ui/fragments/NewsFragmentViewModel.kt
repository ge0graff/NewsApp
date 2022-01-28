package com.example.newsapp.ui.fragments

import androidx.lifecycle.*
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.domain.repository.DataBaseRepository
import com.example.newsapp.domain.repository.NewsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragmentViewModel(private val dataBaseRepository: DataBaseRepository): ViewModel() {

    var newsList = dataBaseRepository.getData()

    fun searchDatabase(searchQuery: String): LiveData<List<Article>> {
        return dataBaseRepository.searchDatabase(searchQuery)
    }



}
