package com.wingsmight.boilerplate.common.extension

import com.wingsmight.boilerplate.common.data.Day
import com.wingsmight.boilerplate.common.data.PhoneNumber
import com.wingsmight.boilerplate.common.data.Time
import com.wingsmight.boilerplate.data.model.auth.User
import java.util.Date

val User.Companion.test: User
    get() = User()

val PhoneNumber.Companion.test: PhoneNumber
    get() = PhoneNumber("9990000000")

val Day.Companion.test: Day
    get() = Day(Date())

val Time.Companion.test: Time
    get() = Time(Date())
