package com.example.domain

import com.example.data.Repo
import com.example.domain.mapper.toGrocery
import com.example.domain.model.Grocery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveGroceriesUseCase(private val repo: Repo) {
    fun createObservable(): Flow<Grocery> {
        return repo.groceries.map { it.toGrocery() }
    }
}