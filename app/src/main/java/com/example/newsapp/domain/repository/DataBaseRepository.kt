package com.example.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.Article
import kotlinx.coroutines.flow.Flow

interface DataBaseRepository {
    fun getData(): LiveData<List<Article>>
    fun searchDatabase(searchQuery: String): LiveData<List<Article>>
    fun deleteDatabase()
}