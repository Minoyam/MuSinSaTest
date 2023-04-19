package com.example.musinsatest.repository

import com.example.musinsatest.data.ContentsResponse
import com.example.musinsatest.data.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getContents(): Flow<Resource<ContentsResponse>>
}