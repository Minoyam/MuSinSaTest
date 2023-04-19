package com.example.musinsatest.datasource

import com.example.musinsatest.data.ContentsResponse
import com.example.musinsatest.data.Resource
import com.example.musinsatest.network.NetworkService
import com.example.musinsatest.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val networkService: NetworkService) : RemoteDataSource {
    override fun getContents(): Flow<Resource<ContentsResponse>> = flow {
        emit(safeApiCall(networkService.getContents()))
    }
}