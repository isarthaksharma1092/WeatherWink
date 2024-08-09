package com.isarthaksharma.weatherwink

data class Hour(
    val condition: Condition,
    val is_day: Int,
    val temp_c: Double,
    val temp_f: Double,
    val time: String,
    val time_epoch: Int
)