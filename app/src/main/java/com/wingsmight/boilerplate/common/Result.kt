package com.wingsmight.boilerplate.common

sealed class Result(val error: Throwable? = null) {
    class Success : Result()
    class Failure(error: Throwable) : Result(error)
}