package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun ScreenTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = Typography.h5,
            modifier = Modifier.padding(all = 4.dp),
            fontWeight = FontWeight.Bold
        )
    }
}