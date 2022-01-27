package com.example.newsapp.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.domain.entity.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDataBaseDao {

    @Query("SELECT * FROM news_dataBase")
    fun reedAllData(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (articles: List<Article>)

    @Query("SELECT * FROM news_dataBase WHERE title LIKE :searchQuery OR description LIKE :searchQuery OR content LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Article>>

    @Query("DELETE FROM news_dataBase")
    fun deleteDatabase()

}