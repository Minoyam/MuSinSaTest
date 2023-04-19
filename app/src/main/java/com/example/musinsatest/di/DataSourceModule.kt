package com.example.musinsatest.di

import com.example.musinsatest.datasource.RemoteDataSource
import com.example.musinsatest.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}