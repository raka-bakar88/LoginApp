package com.bakar.loginapp.data

data class ApiResponse<T> (
    val result : T?,
    val error : Error?
)
