package com.example.retrofitdagger2024.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitdagger2024.model.ProductItem

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductsData(productItem: List<ProductItem>)

    @Query("SELECT * FROM ProductTable ORDER BY id ASC")
    fun readAllProductsData(): List<ProductItem>
}