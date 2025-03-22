package com.bakar.loginapp.di

import com.bakar.loginapp.data.LoginRepository
import com.bakar.loginapp.data.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideLoginRepository(impl: LoginRepositoryImpl): LoginRepository
}