package com.example.newsapp.data.repositories

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.data.mappers.toEntity
import com.example.newsapp.domain.common.LoadDataResult
import com.example.newsapp.domain.repository.NewsApiRepository

class NewsApiRepositoryImpl(private val api: NewsApiService, private val dao: NewsDataBaseDao):
    NewsApiRepository {

    override suspend fun loadDataToDatabase() : LoadDataResult {
        val result = api.getNews()
        return if (result.isSuccessful) {
            dao.insert(result.body()?.articles?.map { it.toEntity() } ?: listOf())
            LoadDataResult(true)
        } else LoadDataResult(false)
    }
}