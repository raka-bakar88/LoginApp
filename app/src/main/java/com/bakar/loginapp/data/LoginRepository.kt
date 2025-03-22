package com.bakar.loginapp.data

import javax.inject.Inject

interface LoginRepository {
    fun login(username: String, password: String): ApiResponse<Int?>
}

class LoginRepositoryImpl @Inject constructor(private val apiService: ApiService): LoginRepository{
    override fun login(username: String, password: String): ApiResponse<Int?> {
        return apiService.login(username = username, password = password)
    }
}