package com.hackathon.unievents.ui.screen.events.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.IconInfo
import com.hackathon.unievents.ui.theme.Typography


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventCard(
    eventName: String,
    modifier: Modifier = Modifier,
    isMyEvent: Boolean = false,
    onClick : () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(height = 200.dp),
        shape = RoundedCornerShape(size = 20.dp),
        elevation = 4.dp,
        onClick = onClick
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.event_card_img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .weight(weight = 2f)
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                EventBody(
                    day = "08",
                    month = "Apr",
                    eventName = eventName,
                    teamName = "Team Lemon",
                    modifier = Modifier
                )
                EventInfoGroup()
            }

        }
    }
}

@Composable
private fun EventBody(
    day: String,
    month: String,
    eventName: String,
    teamName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(size = 16.dp),
            backgroundColor = Color.Gray
        ) {
            Column(
                modifier = Modifier.padding(all = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = day,
                    style = Typography.h6,
                    color = Color.White
                )
                Text(
                    text = month,
                    style = Typography.caption,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.width(width = 10.dp))
        Column{
            Text(
                text = eventName,
                style = Typography.h6
            )
            Text(
                text = teamName,
                style = Typography.overline
            )
        }
    }
}

@Composable
private fun EventInfoGroup(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconInfo(
                text = "3:45 - 7:00 PM",
                iconId = R.drawable.ic_clock,
                fillMaxSize = false,
                modifier = Modifier.weight(weight = 1.5f)
            )
            IconInfo(
                text = "St. Mary Magdolna Center",
                iconId = R.drawable.ic_location,
                modifier = Modifier.weight(weight = 2f)
            )
        }
        IconInfo(text = "25 participants", iconId = R.drawable.ic_participant)
    }
}



