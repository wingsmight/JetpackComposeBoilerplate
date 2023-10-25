package com.wingsmight.boilerplate.data.remote.dto

data class ArrayDataDto<T : DataDto>(
    private val data: Array<T>
) : DataDto() {
    fun toArray(): Array<T> {
        return data
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArrayDataDto<*>

        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}