package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun CustomAlertDialog(
    text: String,
    title: String? = null,
    onConfirm: () -> Unit = {},
    confirmButtonText: String = "Okay",
    confirmButtonTextColor: Color? = null,
    showDismissButton: Boolean = false,
    onDismiss: () -> Unit = {},
    dismissButtonText: String = "Cancel",
    dismissButtonTextColor: Color? = null
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            if (title != null) {
                Text(text = title, style = Typography.subtitle1)
            }
        },
        text = { Text(text = text, style = Typography.subtitle2) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = confirmButtonText, style = Typography.button, color = confirmButtonTextColor ?: MaterialTheme.colors.onSurface)
            }
        },
        dismissButton = {
            if (showDismissButton) {
                TextButton(onClick = onDismiss) {
                    Text(text = dismissButtonText, style = Typography.button, color = dismissButtonTextColor ?: MaterialTheme.colors.onSurface)
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )
}