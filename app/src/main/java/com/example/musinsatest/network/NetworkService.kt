package com.example.musinsatest.network

import com.example.musinsatest.data.ContentsResponse
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {

    @GET("interview/list.json")
    suspend fun getContents(): Response<ContentsResponse>

}