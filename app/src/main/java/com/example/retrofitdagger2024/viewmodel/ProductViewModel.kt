package com.example.retrofitdagger2024.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdagger2024.model.ProductItem
import com.example.retrofitdagger2024.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProductsData()
        }
    }

    val products: LiveData<MutableList<ProductItem>>
        get() = repository.products
}