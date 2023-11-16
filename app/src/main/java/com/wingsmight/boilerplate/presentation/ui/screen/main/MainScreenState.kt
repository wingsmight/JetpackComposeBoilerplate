package com.wingsmight.boilerplate.presentation.ui.screen.main

import com.wingsmight.boilerplate.data.model.auth.User

data class MainScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val user: User? = null,
    val isRecommendationTabBadgeShowing: Boolean = false,
)
