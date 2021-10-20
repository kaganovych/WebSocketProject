package com.example.domain.base

sealed class InvokeStatus<out T : Any?>
object InvokeStarted : InvokeStatus<Nothing>()
data class InvokeSuccess<T>(val data: T) : InvokeStatus<T>()
data class InvokeError(val throwable: Throwable) : InvokeStatus<Nothing>()
