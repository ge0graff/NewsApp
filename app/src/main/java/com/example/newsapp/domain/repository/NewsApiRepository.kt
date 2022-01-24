package com.example.newsapp.domain.repository

import com.example.newsapp.domain.common.LoadDataResult


interface NewsApiRepository {
    suspend fun loadDataToDatabase(): LoadDataResult
}