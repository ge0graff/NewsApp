package com.example.newsapp.domain

import androidx.lifecycle.LiveData
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResponse

interface DataBaseRepository {
    fun getData(): LiveData<List<Article>>
    fun insertData(article: Article)
}