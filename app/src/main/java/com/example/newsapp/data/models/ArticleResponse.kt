package com.example.newsapp.data.models


data class ArticleResponse(
    val id: Int = 0,
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: Source = Source(),
    val title: String = "",
    val url: String = "",
    val urlToImage: String= ""
)