package com.example.musinsatest.data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("contents")
    val contents: Contents = Contents(),
    @SerializedName("footer")
    val footer: Footer? = null,
    @SerializedName("header")
    val header: Header? = null
)