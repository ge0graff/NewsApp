package com.example.newsapp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.newsapp.R
import com.example.newsapp.domain.NewsApiRepository
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModel<SplashActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun findNavController() = findNavController(R.id.fragment_holder)

        viewModel.getInsertNews()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}