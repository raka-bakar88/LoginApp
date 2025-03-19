package com.bakar.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bakar.loginapp.ui.login.LoginScreen
import com.bakar.loginapp.ui.login.LoginViewModel
import com.bakar.loginapp.ui.theme.LoginAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val loginViewModel: LoginViewModel = hiltViewModel()
                    val loginResult by loginViewModel.loginResult.collectAsStateWithLifecycle()
                    LoginScreen(loginResult = loginResult, loginViewModel::onLoginClicked)
                }
            }
        }
    }
}
