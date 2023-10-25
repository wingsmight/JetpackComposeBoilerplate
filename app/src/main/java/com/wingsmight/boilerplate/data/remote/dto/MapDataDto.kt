package com.wingsmight.boilerplate.data.remote.dto

data class MapDataDto<T : DataDto>(
    private val data: Map<String, T>
) : DataDto() {
    fun toMap(): Map<String, T> {
        return data
    }

    fun toValueList(): List<T> {
        return data.values.toList()
    }
}
