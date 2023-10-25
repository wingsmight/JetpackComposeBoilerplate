package com.wingsmight.boilerplate.common.data.navigation

sealed class Screen(
    val route: String,
) {
    open val fullRoute: String = route
    open val navigateRoute: String = route
    open val composableRoute: String = route
}
