package com.swat_uzb.cryptoapp.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToTime(timestamp: Long?): String {
    val stamp = Timestamp(timestamp?.times(1000) ?: return "")
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}