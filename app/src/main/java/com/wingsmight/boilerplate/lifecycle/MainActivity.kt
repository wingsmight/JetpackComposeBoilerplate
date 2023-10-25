package com.wingsmight.boilerplate.lifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wingsmight.boilerplate.presentation.ui.screen.main.MainScreen
import com.wingsmight.boilerplate.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainActivity()
}