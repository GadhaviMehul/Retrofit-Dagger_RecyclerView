package com.example.retrofitdagger2024.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "ProductTable")
@Parcelize
data class ProductItem(

    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String
) : Parcelable