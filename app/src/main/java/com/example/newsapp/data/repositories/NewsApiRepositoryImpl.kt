package com.example.newsapp.data.repositories

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.dataBase.Converters
import com.example.newsapp.data.dataBase.NewsDataBaseDao
import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.NewsApiRepository

class NewsApiRepositoryImpl(private val api: NewsApiService, private val dao: NewsDataBaseDao): NewsApiRepository {

    override suspend fun getInsertNews(){

            val result = api.getNews()

        if(result.body() != null){
            val article = result.body()!!.articles

            for (i in article){
                val author = i.author
                val content = i.content
                val description = i.description
                val publishedAt = i.publishedAt
                val source = i.source
                val title = i.title
                val url = i.url
                val urlToImage = i.urlToImage

                val articleResult = Article(null, author, content, description, publishedAt, source, title, url,urlToImage)
                dao.insert(articleResult)
            }
        }
    }
}