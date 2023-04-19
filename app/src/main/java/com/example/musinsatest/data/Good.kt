package com.example.musinsatest.data


import com.google.gson.annotations.SerializedName

data class Good(
    @SerializedName("brandName")
    val brandName: String = "",
    @SerializedName("hasCoupon")
    val hasCoupon: Boolean = false,
    @SerializedName("linkURL")
    val linkURL: String = "",
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("saleRate")
    val saleRate: Int = 0,
    @SerializedName("thumbnailURL")
    val thumbnailURL: String = ""
)