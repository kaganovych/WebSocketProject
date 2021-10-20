package com.example.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, R> {
    operator fun invoke(params: P): Flow<InvokeStatus<R>> {
        return flow {
            emit(InvokeStarted)
            val result = doWork(params)
            emit(InvokeSuccess(result))
        }.catch { t ->
            emit(InvokeError(t))
        }
    }

    protected abstract suspend fun doWork(params: P): R
}