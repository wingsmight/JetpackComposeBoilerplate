package com.wingsmight.boilerplate.common.data

import java.util.Calendar
import java.util.Date

class Time constructor(
    val hour: Int,
    val minute: Int
) : Comparable<Time>, Iterable<Time> {
    constructor() : this(Calendar.getInstance().time)

    constructor(date: Date) : this(
        Calendar.getInstance().apply { time = date }
            .get(Calendar.HOUR_OF_DAY),
        Calendar.getInstance().apply { time = date }
            .get(Calendar.MINUTE)
    )

    constructor(minutesSinceBeginningOfDay: Int) : this(
        (minutesSinceBeginningOfDay / 60) % 24,
        minutesSinceBeginningOfDay % 60
    )

    fun advancedBy(minutes: Int): Time =
        Time(minutesSinceBeginningOfDay + minutes)

    override fun compareTo(other: Time): Int =
        minutesSinceBeginningOfDay - other.minutesSinceBeginningOfDay

    override fun equals(other: Any?): Boolean =
        other is Time && minutesSinceBeginningOfDay == other.minutesSinceBeginningOfDay

    override fun hashCode(): Int =
        minutesSinceBeginningOfDay

    override fun toString(): String =
        "%02d:%02d".format(hour, minute)

    override fun iterator(): Iterator<Time> {
        return object : Iterator<Time> {
            private var current: Time = this@Time

            override fun hasNext(): Boolean {
                return current <= Time(23, 59)
            }

            override fun next(): Time {
                val result = current
                current = current.advancedBy(60)
                return result
            }
        }
    }

    fun distanceTo(other: Time): Time =
        Time(other.minutesSinceBeginningOfDay - minutesSinceBeginningOfDay)

    val date: Date
        get() = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }.time

    companion object {
        val zero: Time
            get() = Time(0, 0)
    }

    private val minutesSinceBeginningOfDay: Int
        get() = hour * 60 + minute
}

fun ClosedRange<Time>.toList(separateMinutes: Int = 60): List<Time> {
    val list = mutableListOf<Time>()
    var current = start

    while (current <= endInclusive) {
        list.add(current)
        current = current.advancedBy(separateMinutes)
    }

    return list
}

val Date.onlyTime: Time
    get() = Time(this)

fun Date.setTime(time: Time) {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.apply {
        set(Calendar.HOUR_OF_DAY, time.hour)
        set(Calendar.MINUTE, time.minute)
        set(Calendar.SECOND, 0)
    }

    this.time = calendar.timeInMillis
}
