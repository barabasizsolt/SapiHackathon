package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TeamCard(
    team: String,
    captainName: String,
    teamImageId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cornerShape: Dp = 16.dp,
    elevation: Dp = 2.dp,
    showJoinOption: Boolean = false
) {
    Box(modifier = Modifier.wrapContentSize()) {
        if (showJoinOption) {
            Card(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = (-30).dp, y = 5.dp)
                    .zIndex(zIndex = 1f)
                    .wrapContentSize(),
                backgroundColor = Color(color = 0xFF2e7d32),
                onClick =  { /*Join Team*/ },
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Text(
                    text = "Join Team",
                    color = Color.White,
                    style = Typography.overline,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }

        }

        Card(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            shape = RoundedCornerShape(size = cornerShape),
            elevation = elevation,
            onClick = onClick
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 170.dp)
            ) {
                Image(
                    painter = painterResource(id = teamImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(weight = 2f),
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(weight = 1f)
                        .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = team,
                        style = Typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier.weight(weight = 1f),
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(height = 4.dp))
                    Card(
                        backgroundColor = Color.Gray,
                        shape = RoundedCornerShape(size = 20f)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(all = 6.dp)
                                .wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_flag_white),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(size = 18.dp)
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text(
                                text = captainName,
                                style = Typography.overline,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
