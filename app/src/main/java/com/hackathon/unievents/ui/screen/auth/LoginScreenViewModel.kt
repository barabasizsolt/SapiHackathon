package com.hackathon.unievents.ui.screen.auth

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.unievents.ui.screen.util.Event
import kotlinx.coroutines.launch

class LoginScreenViewModel() : ViewModel() {

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var event by mutableStateOf<Event<Action>?>(null)
        private set
    val uiState = mutableStateOf<UiState>(UiState.Normal)
    val uiModel = mutableStateOf<UiModel>(UiModel.Loaded)

    val isButtonEnabled by derivedStateOf { email.isNotEmpty() && password.isNotEmpty() }

    fun login() {
        event = Event(Action.OnLoginSuccess)
    }

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onDialogDismiss() {
        uiState.value = UiState.Normal
    }

    fun onForgotPasswordClicked() {
        event = Event(Action.OnForgotPasswordClicked(email))
    }

    fun onRegisterClicked() {
        event = Event(Action.OnRegisterClicked)
    }

    sealed class UiModel {
        object Empty : UiModel()
        object Loaded : UiModel()
    }

    sealed class UiState {
        object Normal : UiState()
        sealed class Error : UiState() {
            data class ApiError(val message: String) : Error()
            object General : Error()
        }

        object Loading : UiState()
    }

    sealed class Action {
        object OnLoginSuccess : Action()
        data class OnForgotPasswordClicked(val email: String) : Action()
        object OnRegisterClicked : Action()
    }
}