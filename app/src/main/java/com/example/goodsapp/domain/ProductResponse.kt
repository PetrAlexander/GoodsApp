package com.example.goodsapp.domain

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("productItems")
    val productItems: List<ProductItem>
)