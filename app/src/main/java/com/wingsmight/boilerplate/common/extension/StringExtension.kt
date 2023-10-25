package com.wingsmight.boilerplate.common.extension

import android.annotation.SuppressLint
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL

@SuppressLint("DefaultLocale")
fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.toLowerCase().capitalize() }

@Throws(MalformedURLException::class, URISyntaxException::class)
fun String.isValidURL(): Boolean {
    return try {
        URL(this).toURI()
        true
    } catch (e: MalformedURLException) {
        false
    } catch (e: URISyntaxException) {
        false
    }
}
