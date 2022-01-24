package com.example.newsapp.data.api

import com.example.newsapp.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET("/NewsAPI/top-headlines/category/science/in.json")
    suspend fun getNews(): Response<NewsResponse>
}