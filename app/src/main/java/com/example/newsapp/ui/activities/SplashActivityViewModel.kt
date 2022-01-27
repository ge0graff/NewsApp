package com.example.newsapp.ui.activities

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newsapp.domain.repository.DataBaseRepository
import com.example.newsapp.domain.repository.NewsApiRepository

@SuppressLint("CustomSplashScreen")
class SplashActivityViewModel(private val repository: NewsApiRepository, private val dao: DataBaseRepository): ViewModel() {

    fun getInsertNews() = liveData {
        emit(repository.loadDataToDatabase())
    }

    fun deleteDatabase() {
        dao.deleteDatabase()
    }

}