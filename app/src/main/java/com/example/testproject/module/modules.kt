package com.example.testproject.module

import com.example.data.Repo
import com.example.domain.ConnectToSocketUseCase
import com.example.domain.DisconnectFromSocketUseCase
import com.example.domain.ObserveGroceriesUseCase
import com.example.testproject.ui.MainViewModel
import com.example.testproject.ui.grocery.GroceryViewModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val repoModule = module {
    single { Repo(get(), get()) }
}

val commonModule = module {
    single { Moshi.Builder().build() }
    single {
        OkHttpClient.Builder()
            .readTimeout(0, TimeUnit.MILLISECONDS)
            .build()
    }
}

val usecaseModule = module {
    factory { ConnectToSocketUseCase(get()) }
    factory { DisconnectFromSocketUseCase(get()) }
    factory { ObserveGroceriesUseCase(get()) }
}

val viewModelModule = module {
    viewModel { GroceryViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
}