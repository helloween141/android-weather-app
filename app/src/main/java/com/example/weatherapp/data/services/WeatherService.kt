package com.example.weatherapp.data.services

import com.example.weatherapp.data.models.WeatherRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getWeatherData(
        @Query("APPID") app_id: String,
        @Query("q") city: String
    ): Call<WeatherRemote>
}