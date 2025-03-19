package com.bakar.loginapp.di

import com.bakar.loginapp.data.ApiService
import com.bakar.loginapp.data.ApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    @Singleton
    abstract fun provideApiService(impl: ApiServiceImpl): ApiService
}