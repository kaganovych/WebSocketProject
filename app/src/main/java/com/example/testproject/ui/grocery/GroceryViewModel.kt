package com.example.testproject.ui.grocery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ObserveGroceriesUseCase
import com.example.domain.model.Grocery
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GroceryViewModel(
    private val observeGroceriesUseCase: ObserveGroceriesUseCase
): ViewModel() {

    private val list = mutableListOf<Grocery>()

    val groceries = MutableLiveData<List<Grocery>>(emptyList())

    init {
        viewModelScope.launch {
            observeGroceriesUseCase.createObservable().collect {  grocery ->
                list.add(0, grocery)

                groceries.value = list
            }
        }
    }

}