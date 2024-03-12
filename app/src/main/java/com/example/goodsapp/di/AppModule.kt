package com.example.goodsapp.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.goodsapp.data.network.ProductsApi
import com.example.goodsapp.data.network.ProductsPagingSource
import com.example.goodsapp.domain.Product
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProductsApi(): ProductsApi {
        return Retrofit.Builder()
            .baseUrl(ProductsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideProductsPager(
        productsApi: ProductsApi
    ): Pager<Int, Product> {
        return Pager(
            config = PagingConfig(pageSize = ProductsApi.BASE_LIMIT),
        ) {
            ProductsPagingSource(productsApi)
        }
    }
}