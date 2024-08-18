package com.isarthaksharma.weatherwink

data class Current(
    val air_quality: AirQuality,
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val gust_kph: Double,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val last_updated_epoch: Int,
    val precip_in: Double,
    val precip_mm: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val uv: Double,
    val vis_km: Double,
    val wind_kph: Double,
    val wind_mph: Double
)