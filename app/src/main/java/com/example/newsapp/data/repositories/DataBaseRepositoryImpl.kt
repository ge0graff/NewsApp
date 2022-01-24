package com.example.newsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.DataBaseRepository

class DataBaseRepositoryImpl(private val dao: NewsDataBaseDao): DataBaseRepository {
    override fun getData(): LiveData<List<Article>>
        = dao.reedAllData()

    override fun insertData(article: Article)
        = dao.insert(article)
}