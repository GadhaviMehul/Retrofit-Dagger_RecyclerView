package com.example.retrofitdagger2024.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdagger2024.databinding.SingleRowBinding
import com.example.retrofitdagger2024.model.ProductItem

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var products = emptyList<ProductItem>()

    inner class ProductViewHolder(private val itemList: SingleRowBinding) :
        RecyclerView.ViewHolder(itemList.root) {
        fun bind(productItem: ProductItem) {
          itemList.title.text = productItem.title.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = SingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val products = products[position]
        holder.bind(products)
    }

    override fun getItemCount(): Int = products.size

    fun setProductsData(products: MutableList<ProductItem>) {
        this.products = products
    }

}