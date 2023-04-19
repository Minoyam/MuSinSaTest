package com.example.musinsatest.di

import com.example.musinsatest.repository.Repository
import com.example.musinsatest.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(impl: RepositoryImpl): Repository

}