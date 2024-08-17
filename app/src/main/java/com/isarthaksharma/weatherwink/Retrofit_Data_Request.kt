package com.isarthaksharma.weatherwink

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Instance {
    val createRetrofit:weatherApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(weatherApi::class.java)
    }
}