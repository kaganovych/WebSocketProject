package com.example.testproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        viewModel.connectToSocket()
    }

    override fun onStop() {
        super.onStop()
        viewModel.disconnectFromSocket()
    }
}