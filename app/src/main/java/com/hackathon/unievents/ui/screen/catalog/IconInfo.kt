package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun IconInfo(
    text: String,
    iconId: Int,
    modifier: Modifier = Modifier,
    fillMaxSize: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.size(size = 16.dp)
        )
        Text(
            text = text,
            style = Typography.overline,
            modifier = if (fillMaxSize) Modifier.weight(weight = 1f) else Modifier,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}