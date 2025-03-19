package com.bakar.loginapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bakar.loginapp.data.ApiService
import com.bakar.loginapp.ui.login.LoginViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockApiService: ApiService

    private lateinit var loginViewModel: LoginViewModel

    init {
        MockitoAnnotations.openMocks(this)
    }

    @Before
    fun setup() {
        loginViewModel = LoginViewModel(mockApiService)
    }

    @Test
    fun `test error message when email is empty`() = runTest {
        loginViewModel.onLoginClicked("", "password")

        val loginResult = loginViewModel.loginResult.first()
        assertEquals("Email cannot be empty", loginResult)
    }
}