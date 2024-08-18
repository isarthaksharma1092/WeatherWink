package com.isarthaksharma.weatherwink

data class Astro(
    val is_moon_up: Int,
    val is_sun_up: Int,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)