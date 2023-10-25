package com.wingsmight.boilerplate.common.extension

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

fun <K, V> Map<K, out V>.toJson(): String {
    val registrationDayTimeType: Type =
        object : TypeToken<Map<K, V>>() {}.type
    return GsonBuilder()
        .enableComplexMapKeySerialization()
        .create()
        .toJson(this, registrationDayTimeType)
}
