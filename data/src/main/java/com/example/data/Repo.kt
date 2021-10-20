package com.example.data

import com.squareup.moshi.Moshi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class Repo(
    private val client: OkHttpClient,
    private val moshi: Moshi
) {

    private var socket: WebSocket? = null

    val groceries = MutableSharedFlow<GroceryResponse>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    suspend fun connect() {
        val request = Request.Builder()
            .url(BuildConfig.WS_URL)
            .build()

        socket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                val adapter = moshi.adapter(GroceryResponse::class.java)
                val grocery = adapter.fromJson(text) ?: return
                groceries.tryEmit(grocery)
            }
        })
    }

    suspend fun disconnect() {
        socket?.cancel()
        socket = null
    }
}