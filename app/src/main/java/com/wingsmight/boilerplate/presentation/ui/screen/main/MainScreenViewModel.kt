package com.wingsmight.boilerplate.presentation.ui.screen.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = mutableStateOf(MainScreenState())
    val state: State<MainScreenState> = _state
}
