package com.wingsmight.boilerplate.common.extension

inline fun <T, reified R> Array<out T>.mapToArray(transform: (T) -> R): Array<R> {
    return map(transform).toTypedArray()
}
