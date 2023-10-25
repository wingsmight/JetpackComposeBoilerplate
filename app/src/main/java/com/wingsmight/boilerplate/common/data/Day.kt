package com.wingsmight.boilerplate.common.data

import com.wingsmight.boilerplate.common.extension.toFormattedString
import java.util.Calendar
import java.util.Date

class Day(
    rawDate: Date
) : Comparable<Day> {
    companion object

    var date: Date = rawDate
        .clearTimeComponents()
        .time

    constructor() : this(Date())

    fun advancedBy(dayCount: Int): Day =
        Day(
            Calendar.getInstance().apply { time = date }
                .apply { add(Calendar.DAY_OF_MONTH, dayCount) }
                .time
        )

    override fun compareTo(other: Day): Int =
        date.compareTo(other.date)

    override fun equals(other: Any?): Boolean =
        (other is Day) && date == other.date

    override fun hashCode(): Int =
        date.hashCode()

    override fun toString(): String =
        date.dayString ?: date.toString()

    val tomorrow: Day
        get() = Day(
            Calendar.getInstance().apply { time = date }
                .apply { add(Calendar.DAY_OF_MONTH, 1) }
                .time
        )
}

fun ClosedRange<Day>.toList(separateDays: Int = 1): List<Day> {
    val list = mutableListOf<Day>()
    var current = start

    while (current <= endInclusive) {
        list.add(current)
        current = current.advancedBy(separateDays)
    }

    return list
}

fun Date.clearTimeComponents(): Calendar =
    Calendar.getInstance().apply { time = this@clearTimeComponents }
        .apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

val Date.dayString: String?
    get() = this.toFormattedString("dd.MM.yyyy")

val Date.onlyDay: Day
    get() = Day(this)

fun Date.setDay(value: Day) {
    val calendar = Calendar.getInstance().apply { time = value.date }
    val newCalendar = Calendar.getInstance().apply { time = value.date }
    calendar.apply {
        set(Calendar.YEAR, newCalendar.get(Calendar.YEAR))
        set(Calendar.MONTH, newCalendar.get(Calendar.MONTH))
        set(Calendar.DAY_OF_MONTH, newCalendar.get(Calendar.DAY_OF_MONTH))
    }

    this.time = calendar.timeInMillis
}
