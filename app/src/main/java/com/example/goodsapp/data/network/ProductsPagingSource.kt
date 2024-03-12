package com.example.goodsapp.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.goodsapp.domain.Product
import retrofit2.HttpException

class ProductsPagingSource(
    private val productsApi: ProductsApi
) : PagingSource<Int, Product>() {

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(PAGE_ITERATION_SIZE) ?: anchorPage.nextKey?.minus(
            PAGE_ITERATION_SIZE
        )
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val response = productsApi.getProducts(pageNumber * ProductsApi.BASE_LIMIT)

            if (response.isSuccessful) {
                val products = response.body()?.products

                val nextPageNumber = if (products?.isEmpty() == true) null
                else pageNumber + PAGE_ITERATION_SIZE

                val prevPageNumber = if (pageNumber > PAGE_ITERATION_SIZE) pageNumber - PAGE_ITERATION_SIZE
                else null

                return LoadResult.Page(products ?: emptyList(), prevPageNumber, nextPageNumber)
            } else {
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 0
        private const val PAGE_ITERATION_SIZE = 1
    }
}