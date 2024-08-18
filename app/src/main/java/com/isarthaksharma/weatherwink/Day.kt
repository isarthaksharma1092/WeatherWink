package com.isarthaksharma.weatherwink

data class Day(
    val condition: ConditionX,
    val daily_chance_of_rain: Int,
    val daily_chance_of_snow: Int,
    val daily_will_it_rain: Int,
    val daily_will_it_snow: Int,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val uv: Double
)