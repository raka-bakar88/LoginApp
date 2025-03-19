package com.bakar.loginapp.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.bakar.loginapp.R

@Composable
fun LoginScreen(
    loginResult: String,
    onLoginClicked: (String, String) -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_size_large)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = stringResource(id = R.string.email_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_size_small)))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_size_large)))

        Button(
            onClick = { onLoginClicked(email, password) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.login_label))
        }

        LaunchedEffect(loginResult) {
            snackbarHostState.showSnackbar(loginResult)
        }
    }
}