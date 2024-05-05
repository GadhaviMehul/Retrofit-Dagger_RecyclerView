package com.example.retrofitdagger2024.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofitdagger2024.model.ProductItem

@Database(entities = [ProductItem::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

}