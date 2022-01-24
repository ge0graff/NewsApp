package com.example.newsapp.domain

import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResponse
import retrofit2.Response


interface NewsApiRepository {
    suspend fun getInsertNews()
}