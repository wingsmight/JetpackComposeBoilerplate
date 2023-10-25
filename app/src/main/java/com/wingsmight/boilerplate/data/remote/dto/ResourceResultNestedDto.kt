package com.wingsmight.boilerplate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResourceResultNestedDto<T : DataDto>(
    val code: Int,
    val message: String,
    @SerializedName("data")
    val `data`: OuterDataDto<T>,
)
