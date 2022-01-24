package com.example.newsapp.data.mappers

import com.example.newsapp.data.models.ArticleResponse
import com.example.newsapp.domain.entity.Article

fun ArticleResponse.toEntity(): Article = with(this) {
    Article(null, author, content, description, publishedAt, source, title, url, urlToImage)
}