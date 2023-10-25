package com.wingsmight.boilerplate.common.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatusView(
    isLoading: Boolean,
    errorMessage: String?,
): Boolean {
    if (isLoading) {
        Row {
            Spacer(modifier = Modifier.weight(1f))
            CircularProgressIndicator(modifier = Modifier.size(45.dp))
            Spacer(modifier = Modifier.weight(1f))
        }

        return true
    } else if (errorMessage?.isNotEmpty() == true) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colors.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        return true
    }

    return false
}
