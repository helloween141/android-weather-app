package com.example.weatherapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface iWeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("APPID") app_id: String,
        @Query("q") city: String
    ): Call<WeatherResponse>
}