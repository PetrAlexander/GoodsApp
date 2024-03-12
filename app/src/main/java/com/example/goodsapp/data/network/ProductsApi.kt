package com.example.goodsapp.data.network

import com.example.goodsapp.domain.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("productItems")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int = BASE_LIMIT,
    ): ProductResponse

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
        private const val BASE_LIMIT = 20
    }
}