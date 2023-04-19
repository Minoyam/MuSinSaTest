package com.example.musinsatest.repository

import com.example.musinsatest.data.ContentsResponse
import com.example.musinsatest.data.Resource
import com.example.musinsatest.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, ) : Repository {
    override fun getContents(): Flow<Resource<ContentsResponse>> = remoteDataSource.getContents()
}