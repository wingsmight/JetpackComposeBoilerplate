package com.wingsmight.boilerplate.common.data.navigation

sealed class GraphContainer {
    object Root : Graph("Root")

    object Auth : Graph("Auth")
    object Main : Graph("Main")
}