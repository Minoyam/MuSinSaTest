package com.example.musinsatest.data


import com.google.gson.annotations.SerializedName

data class Contents(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("banners")
    val banners: List<Banner> = listOf(),
    @SerializedName("goods")
    val goods: List<Good> = listOf(),
    @SerializedName("styles")
    val styles: List<Style> = listOf()
)