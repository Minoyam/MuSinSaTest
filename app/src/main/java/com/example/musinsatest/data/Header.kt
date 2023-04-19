package com.example.musinsatest.data


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("iconURL")
    val iconURL: String = "",
    @SerializedName("linkURL")
    val linkURL: String = "",
    @SerializedName("title")
    val title: String = ""
)