package com.wingsmight.boilerplate.common

inline fun <T> tryOrNull(f: () -> T) =
    try {
        f()
    } catch (_: Exception) {
        null
    }
