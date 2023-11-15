package com.wingsmight.boilerplate.lifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.wingsmight.boilerplate.presentation.ui.screen.main.NavGraphs
import com.wingsmight.boilerplate.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                setContent {
                    AppTheme {
                        DestinationsNavHost(navGraph = NavGraphs.root)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainActivity()
}
