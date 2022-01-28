package com.example.newsapp.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.SplashActivityBinding
import com.example.newsapp.domain.NetworkConnect
import org.koin.androidx.viewmodel.ext.android.viewModel



@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModel<SplashActivityViewModel>()

    private lateinit var networkConnectManager : NetworkConnect

    private lateinit var bindingMain: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = SplashActivityBinding.inflate(layoutInflater)

        bindingMain.updateButton.setOnClickListener {
            checkNetworkConnection()
        }

        clearDatabase()

        checkNetworkConnection()
    }

    private fun clearDatabase() {
        viewModel.deleteDatabase()
    }

    private fun getToApp() {
        viewModel.getInsertNews().observe(this, {
            if (it.isSuccess) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

    private fun checkNetworkConnection() {

        networkConnectManager = NetworkConnect(this)

        if (networkConnectManager.isOnline()) {
            getToApp()
        } else {
            setContentView(bindingMain.root)
        }
    }


}
