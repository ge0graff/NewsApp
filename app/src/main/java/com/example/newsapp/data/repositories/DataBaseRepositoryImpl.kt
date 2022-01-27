package com.example.newsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.domain.repository.DataBaseRepository
import kotlinx.coroutines.flow.Flow

class DataBaseRepositoryImpl(private val dao: NewsDataBaseDao): DataBaseRepository {
    override fun getData(): LiveData<List<Article>>
        = dao.reedAllData()

    override fun searchDatabase(searchQuery: String): LiveData<List<Article>>
        = dao.searchDatabase(searchQuery)

    override fun deleteDatabase()
        = dao.deleteDatabase()

}