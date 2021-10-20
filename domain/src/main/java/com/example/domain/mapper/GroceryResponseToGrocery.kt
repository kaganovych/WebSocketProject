package com.example.domain.mapper

import com.example.data.GroceryResponse
import com.example.domain.model.Grocery

fun GroceryResponse.toGrocery(): Grocery {
    return Grocery(weight, name, bagColor)
}