package com.example.retrofitdagger2024.di

import android.content.Context
import androidx.room.Room
import com.example.retrofitdagger2024.database.ProductDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getDatabase(context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, "ProductDatabase")
            .fallbackToDestructiveMigration().build()
    }
}