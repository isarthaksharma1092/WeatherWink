package com.isarthaksharma.weatherwink

data class Hour(
    val chance_of_rain: Int,
    val chance_of_snow: Int,
    val condition: Condition,
    val temp_c: Double,
    val time: String,
    val time_epoch: Int,
    val will_it_rain: Int,
    val will_it_snow: Int
)