package com.hackathon.unievents.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.screen.catalog.ScreenTitle
import com.hackathon.unievents.ui.screen.catalog.UniEventsButton
import com.hackathon.unievents.ui.screen.catalog.UniEventsInput
import com.hackathon.unievents.ui.screen.profile.catalog.ProfileAvatar

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(size = 0.dp)
        ) {
            ScreenTitle(
                title = "Profile information",
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 10.dp)
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(all = 20.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
            modifier = Modifier.navigationBarsPadding()
        ) {
            item { Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) { ProfileAvatar() } }
            item { UniEventsInput(label = "Full name", text = "John Doe", isEnabled = false) }
            item { UniEventsInput(label = "E-mail", text = "john.doe@gmail.com", isEnabled = false) }
            item { UniEventsInput(label = "Birthdate", text = "01.23.2004", isEnabled = false) }
            item { UniEventsInput(label = "University", text = "Sapientia Hungarian University", isEnabled = false) }
            item {
                UniEventsButton(
                    text = "Logout",
                    onClick = { viewModel.onLogOutClicked() },
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    isEnabled = true,
                    isLoading = false
                )
            }
        }
    }
}