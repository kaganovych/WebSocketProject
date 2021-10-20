package com.example.domain.base

abstract class UseCaseSync<in P, out R : Any> {
    suspend operator fun invoke(params: P): InvokeStatus<R> {
        return try {
            val result = run(params)
            InvokeSuccess(result)
        } catch (t: Throwable) {
            InvokeError(t)
        }
    }

    protected abstract suspend fun run(params: P): R
}