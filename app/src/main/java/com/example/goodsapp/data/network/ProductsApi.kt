package com.example.goodsapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int = BASE_LIMIT,
    ): Response<ProductResponse>

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
        const val BASE_LIMIT = 20
    }
}