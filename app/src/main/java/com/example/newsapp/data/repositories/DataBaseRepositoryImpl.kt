package com.example.newsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.domain.repository.DataBaseRepository

class DataBaseRepositoryImpl(private val dao: NewsDataBaseDao): DataBaseRepository {
    override fun getData(): LiveData<List<Article>>
        = dao.reedAllData()

    override fun insertData(article: Article)
        = dao.insert(article)
}