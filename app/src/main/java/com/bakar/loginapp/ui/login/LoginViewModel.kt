package com.bakar.loginapp.ui.login

import androidx.lifecycle.ViewModel
import com.bakar.loginapp.data.ApiService
import com.bakar.loginapp.data.Error
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _loginResult = MutableStateFlow("")
    val loginResult: StateFlow<String> = _loginResult

    fun onLoginClicked(email: String, password: String) {
        if (email.isEmpty()) {
            _loginResult.value = "Error: Email cannot be empty"
            return
        }
        if (password.isEmpty()) {
            _loginResult.value = "Error: Password cannot be empty"
            return
        }

        val response = apiService.login(email, password)
        when (response.error) {
            Error.WRONG_CREDENTIALS -> _loginResult.value = "Error: Wrong Credentials"
            Error.INTERNAL_SERVER_ERROR -> _loginResult.value = "Error: Server Error"
            null -> _loginResult.value = "Login Successful!"
            else -> _loginResult.value = "Error: Unknown Error"
        }
    }

}