package com.example.goodsapp.data.network

import com.example.goodsapp.domain.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products")
    val products: List<Product>
)