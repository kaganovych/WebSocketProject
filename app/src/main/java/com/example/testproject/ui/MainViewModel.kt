package com.example.testproject.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ConnectToSocketUseCase
import com.example.domain.DisconnectFromSocketUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val connectToSocketUseCase: ConnectToSocketUseCase,
    private val disconnectFromSocketUseCase: DisconnectFromSocketUseCase
): ViewModel() {

    val isConnected = MutableLiveData(false)

    fun connectToSocket() {
        viewModelScope.launch {
            connectToSocketUseCase.invoke(Unit)
            isConnected.value = true
        }
    }

    fun disconnectFromSocket() {
        viewModelScope.launch {
            disconnectFromSocketUseCase.invoke(Unit)
            isConnected.value = false
        }
    }

    fun toggleConnection() {
        if (isConnected.value == true) {
            disconnectFromSocket()
        } else {
            connectToSocket()
        }
    }
}