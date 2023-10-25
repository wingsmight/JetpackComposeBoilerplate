package com.wingsmight.boilerplate.common.data.navigation

import android.net.Uri
import androidx.navigation.NamedNavArgument
import com.wingsmight.boilerplate.common.extension.isValidURL

sealed class ArgumentedScreen(
    route: String,
    val navArguments: List<NamedNavArgument>
) : Screen(route) {
    override val fullRoute: String =
        route + navArguments.getRoute()

    override val composableRoute: String =
        route + navArguments.joinToString(
            prefix = "/{",
            separator = "}/{",
            postfix = "}",
        ) { it.name }

    fun getNavigateRoute(arguments: List<Any>): String {
        val arguments = arguments.map { argument ->
            if (argument is String) {
                if (argument.isValidURL() || argument.contains("http")) {
                    Uri.encode(argument)
                } else {
                    argument
                }
            } else {
                argument
            }
        }

        return route + arguments.joinToString(prefix = "/", separator = "/")
    }

    private fun List<NamedNavArgument>.getRoute(): String {
        return if (isEmpty()) {
            ""
        } else {
            joinToString(prefix = "/", separator = "/") { it.name }
        }
    }
}
