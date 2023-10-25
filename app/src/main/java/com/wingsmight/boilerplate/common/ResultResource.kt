package com.wingsmight.boilerplate.common

sealed class ResultResource(val message: String? = null) {
    class Success : ResultResource()
    class Failure(message: String) : ResultResource(message)
    class Loading : ResultResource()
}