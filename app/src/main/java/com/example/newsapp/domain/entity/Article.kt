package com.example.newsapp.domain.entity

import androidx.room.*
import com.example.newsapp.data.models.Source

@Entity(tableName = "news_dataBase")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)