package com.example.musinsatest.data


import com.google.gson.annotations.SerializedName

data class ContentsResponse(
    @SerializedName("data")
    val dataList: List<Data> = listOf()
)