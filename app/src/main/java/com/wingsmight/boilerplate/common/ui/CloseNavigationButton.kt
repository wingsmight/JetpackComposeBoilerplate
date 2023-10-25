package com.wingsmight.boilerplate.common.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CloseNavigationButton(navController: NavController) {
    IconButton(onClick = {
        navController.popBackStack()
    }) {
        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
    }
}
