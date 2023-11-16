package com.wingsmight.boilerplate.presentation.ui.screen.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wingsmight.boilerplate.common.extension.test
import com.wingsmight.boilerplate.data.model.auth.User
import com.wingsmight.boilerplate.presentation.ui.theme.AppTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.value

    MainScreenContent(
        state = state,
        modifier = modifier,
    )
}

@Composable
private fun MainScreenContent(
    state: MainScreenState,
    modifier: Modifier = Modifier,
) {
    Text("Main screen") // TODO: replace
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreenContent(
            state = MainScreenState(user = User.test),
        )
    }
}
