package com.hackathon.unievents.ui.screen.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hackathon.unievents.ui.screen.util.Event

class EventViewModel : ViewModel() {

    var event by mutableStateOf<Event<Action>?>(null)
        private set

    fun onEventClicked() {
        event = Event(Action.NavigateToEventDetailScreen)
    }

    sealed class Action {
        object NavigateToEventDetailScreen: Action() // Todo [high] pass id
        object NavigateToTeamDetailScreen: Action() // Todo [high] pass id
    }
}