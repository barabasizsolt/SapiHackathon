package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun ScreenHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
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
                text = subtitle,
                style = Typography.overline,
                modifier = Modifier.padding(all = 8.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}