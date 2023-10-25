package com.wingsmight.boilerplate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OuterDataDto<T : DataDto>(
    @SerializedName("data")
    val `data`: T
)