package com.example.domain

import com.example.data.Repo
import com.example.domain.base.UseCaseSync

class ConnectToSocketUseCase(private val repo: Repo): UseCaseSync<Unit, Unit>() {
    override suspend fun run(params: Unit) {
        repo.connect()
    }
}