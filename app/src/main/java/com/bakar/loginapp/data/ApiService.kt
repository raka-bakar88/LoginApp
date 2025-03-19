package com.bakar.loginapp.data

interface ApiService {
    fun login(username: String, password: String): ApiResponse<Int?>
}

class ApiServiceImpl : ApiService {
    override fun login(username: String, password: String): ApiResponse<Int?> {
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