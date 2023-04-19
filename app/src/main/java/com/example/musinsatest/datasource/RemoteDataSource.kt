package com.example.musinsatest.datasource

import com.example.musinsatest.data.ContentsResponse
import com.example.musinsatest.data.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getContents() : Flow<Resource<ContentsResponse>>
}