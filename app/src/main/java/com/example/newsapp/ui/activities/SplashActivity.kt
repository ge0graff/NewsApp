package com.example.newsapp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.newsapp.domain.NetworkConnect
import org.koin.androidx.viewmodel.ext.android.viewModel



@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModel<SplashActivityViewModel>()

    private lateinit var networkConnectManager : NetworkConnect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        networkConnectManager.observe(this, { isConnected ->

            if (isConnected){

                getToApp()

            }else{
                Log.d("Test", "No connect")
                Toast.makeText(this, "No connect", Toast.LENGTH_LONG).show()
            }
        })
    }
}