package com.wingsmight.boilerplate.common.extension

import java.util.Currency

val Currency.shortSymbol: String
    get() {
        return if (this.currencyCode == "RUB") {
            "₽"
        } else {
            this.currencyCode
        }
    }