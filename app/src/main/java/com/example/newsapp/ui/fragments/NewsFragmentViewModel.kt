package com.example.newsapp.ui.fragments

import androidx.lifecycle.*
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.domain.repository.DataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragmentViewModel(private val repository: DataBaseRepository): ViewModel() {

    var newsList = repository.getData()

    fun searchDatabase(searchQuery: String): LiveData<List<Article>> {
        return repository.searchDatabase(searchQuery)
    }


}
