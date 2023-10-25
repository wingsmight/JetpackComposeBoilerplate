package com.wingsmight.boilerplate.common.extension

fun MutableMap<String, String>.getValueStartingWith(prefix: String): String? {
    for ((key, value) in this) {
        if (key.startsWith(prefix)) {
            return value
        }
    }

    return null
}
