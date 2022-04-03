package com.hackathon.unievents.ui.screen.auth.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun AuthScreenHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        Text(
            text = title,
            style = Typography.h4,
            modifier = Modifier.padding(all = 4.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            style = Typography.subtitle2,
            modifier = Modifier.padding(all = 4.dp),
            color = Color.Gray
        )
    }
}