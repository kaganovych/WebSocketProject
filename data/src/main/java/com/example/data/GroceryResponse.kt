package com.example.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GroceryResponse(
    @Json(name = "weight")
    val weight: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "bagColor")
    val bagColor: String
)
