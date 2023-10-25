package com.wingsmight.boilerplate.common.data

data class PhoneNumber(
    private val rawValue: String
) {
    companion object

    val valueWithoutCountryCode: String
        get() = rawValue

    fun toFormattedString(): String {
        val formattedStringValue = rawValue

        val countryCode = "+7"
        val digits = formattedStringValue.filter { it.isDigit() }
        val firstThree = digits.take(3)
        val middleThree = digits.drop(3).take(3)
        val lastFour = digits.drop(6).take(4)

        return "$countryCode ($firstThree) $middleThree $lastFour"
    }

    override fun toString(): String {
        return toFormattedString()
    }
}

