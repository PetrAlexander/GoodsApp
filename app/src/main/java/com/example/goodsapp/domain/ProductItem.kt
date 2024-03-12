package com.example.goodsapp.domain

import com.google.gson.annotations.SerializedName

data class ProductItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
//    val brand: String,
//    val category: String,
//    val discountPercentage: Double,
//    val images: List<String>,
//    val price: Int,
//    val rating: Double,
//    val stock: Int,
)