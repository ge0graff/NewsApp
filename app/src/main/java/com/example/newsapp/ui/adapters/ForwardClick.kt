package com.example.newsapp.ui.adapters

import com.example.newsapp.domain.entity.Article

interface ForwardClick {
    fun onDetails(news: Article)
}