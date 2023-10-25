package com.wingsmight.boilerplate.common.data.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class ScreenContainer {
    // Auth
    object LogIn : Screen("LogIn")
    object LogInVerification : ArgumentedScreen(
        "LogInVerification",
        listOf(
            navArgument(ScreenArgumentContainer.PHONE_NUMBER) {
                type = NavType.StringType
            },
        ),
    )

    // Main
    object History : Screen("History")
    object Recommendation : Screen("Recommendation")
    object Registration : Screen("Registration")

    // SubMain
    object Order : ArgumentedScreen(
        "Order",
        listOf(
            navArgument(ScreenArgumentContainer.ORDER) {
                type = NavType.StringType
            },
        ),
    )

    object WorkChoiceRegistration : ArgumentedScreen(
        "WorkChoiceRegistration",
        listOf(
            navArgument(ScreenArgumentContainer.SERVICE) {
                type = NavType.StringType
            },
            navArgument(ScreenArgumentContainer.REGISTRATION_DAY_TIME) {
                type = NavType.StringType
            },
        ),
    )

    object DateChoiceRegistration : ArgumentedScreen(
        "DateChoiceRegistration",
        listOf(
            navArgument(ScreenArgumentContainer.SELECTED_PRODUCT_LIST) {
                type = NavType.StringType
            },
            navArgument(ScreenArgumentContainer.OTHER_WORK_DESCRIPTION) {
                type = NavType.StringType
            },
            navArgument(ScreenArgumentContainer.REGISTRATION_DAY_TIME) {
                type = NavType.StringType
            },
        ),
    )
}
