package com.hackathon.unievents.ui.screen.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.screen.catalog.CustomAlertDialog
import com.hackathon.unievents.ui.screen.catalog.UniEventsButton
import com.hackathon.unievents.ui.screen.catalog.UniEventsInput
import com.hackathon.unievents.ui.screen.auth.catalog.AuthScreenHeader

@Composable
fun LoginScreen(viewModel: LoginScreenViewModel) {
    when (viewModel.uiModel.value) {
        is LoginScreenViewModel.UiModel.Loaded -> ScreenContent(viewModel = viewModel)
        else -> Unit
    }

    //Error handling
    when (val uiState = viewModel.uiState.value) {
        is LoginScreenViewModel.UiState.Error.ApiError ->
            CustomAlertDialog(
                text = uiState.message,
                onConfirm = { viewModel.onDialogDismiss() }
            )
        is LoginScreenViewModel.UiState.Error.General -> CustomAlertDialog(
            text = "Something went wrong, please try again later.",
            onConfirm = { viewModel.onDialogDismiss() }
        )
        else -> Unit
    }
}

@Composable
private fun ScreenContent(viewModel: LoginScreenViewModel) {

    val localFocusManager = LocalFocusManager.current

    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
            .imePadding()
    ) {
        item {
            AuthScreenHeader(
                title = "Sign In",
                subtitle = "Please sign in into your account"
            )
        }
        item {
            UniEventsInput(
                label = "Email",
                text = viewModel.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            UniEventsInput(
                label = "Password",
                text = viewModel.password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    localFocusManager.clearFocus()
                    viewModel.login()
                })
            )
        }
        item {
            UniEventsButton(
                text = "Sign In",
                onClick = { viewModel.login() },
                color = Color.Magenta.copy(alpha = 0.3f),
                isEnabled = viewModel.isButtonEnabled,
                isLoading = viewModel.uiState.value is LoginScreenViewModel.UiState.Loading,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Forgot password?",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .clickable { viewModel.onForgotPasswordClicked() }
                )
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Create Account",
                    color = Color.White,
                    modifier = Modifier.clickable { viewModel.onRegisterClicked() }
                )
            }
        }
    }
}