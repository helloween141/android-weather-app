package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.api.RetrofitClient
import com.example.weatherapp.api.WeatherResponse
import com.example.weatherapp.api.iWeatherService
import com.example.weatherapp.constants.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class WeatherRepository : iWeatherRepository {
    override suspend fun getWeatherDataFromAPI(): MutableLiveData<String> {
        return RetrofitClient.weatherService.getWeatherData(Constants.appid, "Moscow")
    }
}