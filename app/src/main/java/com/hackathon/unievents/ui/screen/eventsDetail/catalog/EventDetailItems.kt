package com.hackathon.unievents.ui.screen.eventsDetail.catalog

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.TeamCard
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun EventDetailHolder(
    modifier: Modifier = Modifier,
    onEventClicked: () -> Unit
) {

    val listState = rememberLazyListState()

    val transition = updateTransition(listState.firstVisibleItemIndex != 0, label = "Image Size Transition")

    val cornerRadius by transition.animateDp(
        label = "",
        transitionSpec = { tween(easing = LinearEasing) }
    ) { isScrolling ->
        if (isScrolling) 0.dp else 20.dp
    }

    val padding by transition.animateDp(
        label = "",
        transitionSpec = { tween(easing = LinearEasing) }
    ) { isScrolling ->
        if (isScrolling) 0.dp else 100.dp
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.event_card_img),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-60).dp),
            contentScale = ContentScale.Fit
        )
        Card(
            shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
            modifier = Modifier
                .padding(top = padding)
                .fillMaxSize(),
            backgroundColor = Color.White
        ) {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(all = 20.dp),
                verticalArrangement = Arrangement.spacedBy(space = 12.dp)
            ) {
                item {
                    EventDetailHeader(
                        eventName = "Mobile School",
                        team = "Team Lemon",
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }
                item {
                    EventDetailItem(
                        iconId = R.drawable.ic_calendar_white,
                        text = "Wednesday, 29.01.2022"
                    )
                }
                item {
                    EventDetailItem(
                        iconId = R.drawable.ic_clock_white,
                        text = "2:45 - 7:45 PM"
                    )
                }
                item {
                    EventDetailItem(
                        iconId = R.drawable.ic_location_white,
                        text = "Sapientia Hungarian University",
                        subText = "12 Cadol Heverlee, Leuven, 3009, Belgium"
                    )
                }
                item {
                    EventDetailDescription(
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam rutrum tempus ex eget lacinia. Donec vel erat ut est varius tristique. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor libero felis, id vehicula nulla lacinia fringilla. Cras faucibus nisl rutrum",
                        modifier = Modifier.padding(top = 20.dp)
                    )
                }
                item {
                    EventDetailDivider(
                        text = "Registered Teams",
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .offset(y = 8.dp)
                    )
                }
                item {
                    EventDetailItem(
                        iconId = R.drawable.ic_people_white,
                        text = "22 registered teams"
                    )
                }
                for (i in 0..10) {
                    item {
                        TeamCard(
                            team = "Team Lemonade",
                            captainName = "John Doe",
                            teamImageId = R.drawable.event_detail_team_img,
                            onClick = { onEventClicked() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EventDetailHeader(
    eventName: String,
    team: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = eventName,
            style = Typography.h5,
            modifier = Modifier.padding(all = 4.dp),
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(size = 20f),
            backgroundColor = Color.Gray
        ) {
            Text(
                text = team,
                style = Typography.overline,
                modifier = Modifier.padding(all = 8.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
private fun EventDetailDivider(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            style = Typography.body1,
            modifier = Modifier.padding(all = 4.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun EventDetailItem(
    iconId: Int,
    text: String,
    modifier: Modifier = Modifier,
    subText: String? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = if (subText != null) Alignment.Top else Alignment.CenterVertically
    ) {
        EventDetailIcon(iconId = iconId)
        Spacer(modifier = Modifier.width(width = 12.dp))
        Column(
            modifier = Modifier.weight(weight = 1f)
        ) {
            Text(
                text = text,
                style = Typography.body2,
                modifier = if (subText != null) Modifier.padding(top = 6.dp) else Modifier
            )
            if (subText != null) {
                Spacer(modifier = Modifier.height(height = 4.dp))
                Text(
                    text = subText,
                    style = Typography.caption,
                    color = Color.Gray,
                    modifier = Modifier.width(width = 200.dp)
                )
            }
        }
    }
}

@Composable
private fun EventDetailIcon(iconId: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(size = 33.dp),
        shape = RoundedCornerShape(size = 18f),
        backgroundColor = Color.Gray
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .size(size = 28.dp)
                .padding(all = 6.dp)
        )
    }
}

@Composable
private fun EventDetailDescription(
    description: String,
    modifier: Modifier = Modifier,
) {
    var isExpanded by remember { mutableStateOf(value = false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
            .clipToBounds()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    ) {
        Text(
            text = "Event description",
            style = Typography.body1,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(height = 10.dp))
        Text(
            text = description,
            style = Typography.caption,
            color = Color.Gray,
            maxLines = if (isExpanded) 20 else 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}
