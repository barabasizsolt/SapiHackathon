package com.hackathon.unievents.ui.screen.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.ScreenTitle
import com.hackathon.unievents.ui.screen.events.catalog.EventCard

@Composable
fun EventScreen(viewModel: EventViewModel) {

    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("My Events", "Other Events")

    Column {
        ScreenTitle(
            title = "Upcoming Events",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 10.dp)
        )
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier.height(height = 55.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) },
                    icon = {
                        when (index) {
                            0 -> { GetTabIcon(iconId = R.drawable.ic_favourite) }
                            1 -> { GetTabIcon(iconId = R.drawable.ic_other_events) }
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> MyEventsTab(onEventClick = { viewModel.onEventClicked() })
            1 -> EventsTab(onEventClick = { viewModel.onEventClicked() })
        }
    }
}

@Composable
private fun GetTabIcon(iconId: Int, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = iconId),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
private fun MyEventsTab(
    onEventClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = modifier
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        for (i in 0..5) {
            item {
                EventCard(
                    eventName = "My Events",
                    isMyEvent = true,
                    onClick = { onEventClick() }
                )
            }
        }
    }
}

@Composable
private fun EventsTab(
    onEventClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        modifier = modifier
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        for (i in 0..5) {
            item {
                EventCard(
                    eventName = "Other Events",
                    onClick = { onEventClick() }
                )
            }
        }
    }
}