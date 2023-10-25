package com.wingsmight.boilerplate.common

inline fun <T1 : Any> guardLet(
    p1: T1?,
    closure: () -> Nothing
): T1 {
    return p1 ?: closure()
}

inline fun <T1 : Any, T2 : Any> guardLet(
    p1: T1?,
    p2: T2?,
    closure: () -> Nothing
): Pair<T1, T2> {
    return if (p1 != null && p2 != null) {
        Pair(p1, p2)
    } else {
        closure()
    }
}

inline fun <T1 : Any, T2 : Any, T3 : Any> guardLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    closure: () -> Nothing
): Triple<T1, T2, T3> {
    return if (p1 != null &&
        p2 != null &&
        p3 != null
    ) {
        Triple(p1, p2, p3)
    } else {
        closure()
    }
}
