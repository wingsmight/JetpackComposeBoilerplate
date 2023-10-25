package com.wingsmight.boilerplate.common.extension

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.navOptions
import androidx.navigation.navigation
import com.wingsmight.boilerplate.common.data.navigation.ArgumentedScreen
import com.wingsmight.boilerplate.common.data.navigation.Graph
import com.wingsmight.boilerplate.common.data.navigation.Screen

@Composable
fun NavHost(
    navController: NavHostController,
    startDestinationGraph: Graph,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    graph: Graph,
    enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition,
    popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition,
    builder: NavGraphBuilder.() -> Unit
) {
    val startDestination = startDestinationGraph.route
    val route = graph.route

    androidx.navigation.compose.NavHost(
        navController,
        remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, builder)
        },
        modifier,
        contentAlignment,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition
    )
}

@Composable
fun NavHost(
    navController: NavHostController,
    startDestinationScreen: Screen,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    graph: Graph,
    enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition,
    popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition,
    builder: NavGraphBuilder.() -> Unit
) {
    val startDestination = startDestinationScreen.fullRoute
    val route = graph.route

    androidx.navigation.compose.NavHost(
        navController,
        remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, builder)
        },
        modifier,
        contentAlignment,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition
    )
}

@Composable
fun NavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    graph: Graph,
    enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition,
    popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition,
    builder: NavGraphBuilder.() -> Unit
) {
    val route = graph.route

    androidx.navigation.compose.NavHost(
        navController,
        remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, builder)
        },
        modifier,
        contentAlignment,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition
    )
}

fun NavController.navigate(
    screen: Screen,
    arguments: List<Any>,
    builder: NavOptionsBuilder.() -> Unit
) {
    if (screen is ArgumentedScreen) {
        navigate(screen, arguments, builder)
    } else {
        navigate(screen, builder)
    }
}

fun NavController.navigate(
    screen: Screen,
    builder: NavOptionsBuilder.() -> Unit
) {
    navigate(screen.navigateRoute, navOptions(builder))
}

fun NavController.navigate(
    screen: ArgumentedScreen,
    arguments: List<Any>,
    builder: NavOptionsBuilder.() -> Unit
) {
    val arguments = arguments.take(screen.navArguments.size)
    val navigateRoute = screen.getNavigateRoute(arguments)
    navigate(navigateRoute, navOptions(builder))
}

fun NavController.navigate(
    screen: Screen,
    arguments: List<Any>,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    if (screen is ArgumentedScreen) {
        navigate(
            screen = screen,
            arguments = arguments,
            navOptions = navOptions,
            navigatorExtras = navigatorExtras,
        )
    } else {
        navigate(
            screen = screen,
            navOptions = navOptions,
            navigatorExtras = navigatorExtras,
        )
    }
}

fun NavController.navigate(
    screen: Screen,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    navigate(
        screen.navigateRoute,
        navOptions,
        navigatorExtras
    )
}

fun NavController.navigate(
    screen: ArgumentedScreen,
    arguments: List<Any>,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val arguments = arguments.take(screen.navArguments.size)
    val navigateRoute = screen.getNavigateRoute(arguments)

    navigate(
        navigateRoute,
        navOptions,
        navigatorExtras
    )
}

fun NavController.navigate(
    graph: Graph,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val navigateRoute = graph.route

    navigate(
        navigateRoute,
        navOptions,
        navigatorExtras
    )
}

fun NavController.navigate(
    graph: Graph,
    builder: NavOptionsBuilder.() -> Unit
) {
    val navigateRoute = graph.route

    navigate(navigateRoute, builder)
}

fun NavController.getBackStackEntry(screen: Screen): NavBackStackEntry {
    return getBackStackEntry(screen.fullRoute)
}

fun NavGraphBuilder.composable(
    graph: Graph,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = graph.route,
        content = content,
    )
}

fun NavGraphBuilder.composable(
    screen: Screen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    if (screen is ArgumentedScreen) {
        composable(
            route = screen.composableRoute,
            arguments = screen.navArguments,
            content = content,
        )
    } else {
        composable(
            route = screen.composableRoute,
            content = content,
        )
    }
}

inline fun NavGraphBuilder.navigation(
    startScreen: Screen,
    graph: Graph,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = startScreen.composableRoute,
        route = graph.route,
        builder = builder,
    )
}
