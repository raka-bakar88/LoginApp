package com.bakar.loginapp.data

import timber.log.Timber
import javax.inject.Inject

interface ApiService {
    fun login(username: String, password: String): ApiResponse<Int?>
}

class ApiServiceImpl @Inject constructor() : ApiService {
    override fun login(username: String, password: String): ApiResponse<Int?> {
        Timber.d("login username :  $username password $password")
        return when (username) {
            "user" -> {
                ApiResponse(
                    result = 1,
                    error = null
                )
            }

            "wrong" -> {
                ApiResponse(
                    result = null,
                    error = Error.WRONG_CREDENTIALS
                )
            }

            "internal" -> {
                ApiResponse(
                    result = null,
                    error = Error.INTERNAL_SERVER_ERROR
                )
            }

            else -> {
                ApiResponse(
                    result = null,
                    error = Error.UNKNOWN_ERROR
                )
            }
        }
    }
}