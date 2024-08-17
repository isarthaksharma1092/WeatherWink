package com.isarthaksharma.weatherwink

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface weatherApi {
    @GET("forecast.json")
    suspend fun weatherRequest(
        @Query("q") q:String,
        @Query("key") key: String ="Enter Your API KEY here",
        @Query("days") days: Int = 1
    ): Response<dataClass_Weather>
}