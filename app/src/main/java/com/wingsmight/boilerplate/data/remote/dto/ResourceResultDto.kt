package com.wingsmight.boilerplate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResourceResultDto<T : DataDto>(
    val code: Int,
    val message: String,
    @SerializedName("data")
    val `data`: T,
)
