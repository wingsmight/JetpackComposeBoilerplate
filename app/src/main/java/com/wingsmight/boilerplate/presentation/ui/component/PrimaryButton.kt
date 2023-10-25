package com.wingsmight.boilerplate.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wingsmight.boilerplate.presentation.ui.theme.AppTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White,
        ),
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(5.dp),
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    var isEnabled by remember { mutableStateOf(true) }

    AppTheme {
        PrimaryButton(
            text = "Test button",
            onClick = { isEnabled = !isEnabled },
            isEnabled = isEnabled,
        )
    }
}
