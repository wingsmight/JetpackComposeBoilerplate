package com.wingsmight.boilerplate.data.remote.dto

import com.wingsmight.boilerplate.common.Result

data class ResultDto(
    val code: Int,
    val message: String
)

fun ResultDto.toResult(): Result {
    val successCode = 200
    val successMessage = "ok"

    return if (code == successCode && message == successMessage) {
        Result.Success()
    } else {
        Result.Failure(Error("Error $code: $message"))
    }
}