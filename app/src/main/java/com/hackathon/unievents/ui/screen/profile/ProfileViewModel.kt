package com.hackathon.unievents.ui.screen.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hackathon.unievents.ui.screen.util.Event

class ProfileViewModel : ViewModel() {

    var event by mutableStateOf<Event<Action>?>(null)
        private set

    fun onLogOutClicked() {
        event = Event(Action.LogOut)
    }

    sealed class Action {
        object LogOut: Action()
    }
}