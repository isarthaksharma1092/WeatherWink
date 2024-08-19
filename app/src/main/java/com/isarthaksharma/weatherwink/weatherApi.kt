package com.isarthaksharma.weatherwink

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface weatherApi {
    @GET("forecast.json")
    suspend fun weatherRequest(
        @Query("q") q:String,
        @Query("key") key: String ="ENTER_YOUR_API_KEY_HERE",
        @Query("days") days: Int = 1,
        @Query("aqi") aqi:String = "yes",
        @Query("alerts") alerts:String="yes"
    ): Response<dataClass_Weather>
}