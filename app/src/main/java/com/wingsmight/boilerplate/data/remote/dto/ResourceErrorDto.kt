package com.wingsmight.boilerplate.data.remote.dto

data class ResourceErrorDto(
    val code: Int,
    val message: String,
) {
    val localizedMessage: String
        get() = "Error $code: $message."
}