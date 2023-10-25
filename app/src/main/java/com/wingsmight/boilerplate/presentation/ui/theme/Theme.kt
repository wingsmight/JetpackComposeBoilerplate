package com.wingsmight.boilerplate.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Color.DarkGray,
    onPrimary = Color.Black,

    secondary = Color.Gray,
    secondaryVariant = DarkDarkGray,
    onSecondary = LightLightGray,

    background = Color.Black,
    onBackground = Color.White,

    surface = DarkDarkGray,
    onSurface = LightLightGray,

    error = Color.Red,
    onError = Color.LightGray,
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.LightGray,
    onPrimary = Color.White,

    secondary = DarkDarkGray,
    secondaryVariant = LightLightGray,
    onSecondary = Color.Black,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,

    error = Color.Red,
    onError = Color.LightGray,
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colors.background)

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}