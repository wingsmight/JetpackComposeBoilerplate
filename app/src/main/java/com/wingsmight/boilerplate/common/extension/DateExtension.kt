package com.wingsmight.boilerplate.common.extension

import com.wingsmight.boilerplate.common.data.Day
import com.wingsmight.boilerplate.common.data.Time
import com.wingsmight.boilerplate.common.data.setDay
import com.wingsmight.boilerplate.common.data.setTime
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toFormattedString(format: String): String =
    SimpleDateFormat(format, Locale.getDefault()).format(this)

fun Date(
    day: Day,
    time: Time,
): Date =
    Date()
        .apply { setDay(day) }
        .apply { setTime(time) }
