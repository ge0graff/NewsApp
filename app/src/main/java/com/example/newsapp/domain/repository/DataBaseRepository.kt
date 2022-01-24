package com.example.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.Article

interface DataBaseRepository {
    fun getData(): LiveData<List<Article>>
    fun insertData(article: Article)
}