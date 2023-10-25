package com.wingsmight.boilerplate.common.data

import com.wingsmight.boilerplate.common.extension.shortSymbol
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class Money(
    val count: Int,
    currency: Currency? = null
) {
    private val currency: Currency

    init {
        this.currency = currency
            ?: (Currency
                .getAvailableCurrencies()
                .firstOrNull { it.currencyCode == "RUB" }
                ?: Currency.getInstance("RUB"))
    }

    operator fun times(count: Int): Money {
        return Money(this.count * count, currency)
    }

    override fun toString(): String {
        val formattedCount = NumberFormat
            .getNumberInstance(Locale("ru", "RU"))
            .format(count.toLong())
        val countText = formattedCount ?: count.toString()
        return "$countText ${currency.shortSymbol}"
    }
}
