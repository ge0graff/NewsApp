package com.example.newsapp.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.data.models.Article

@Dao
interface NewsDataBaseDao {

    @Query("SELECT * FROM news_dataBase")
    fun reedAllData(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (article: Article)

}