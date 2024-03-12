package com.example.goodsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.example.goodsapp.domain.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    pager: Pager<Int, Product>
): ViewModel() {
    val productsPagingFlow = pager.flow.cachedIn(viewModelScope)
}