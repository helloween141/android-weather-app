package com.example.weatherapp.domain.repositories

import com.example.weatherapp.data.models.WeatherRemote
import com.example.weatherapp.data.network.RetrofitFactory
import retrofit2.Call

class WeatherRepository : iWeatherRepository {
    override suspend fun getWeatherDataFromAPI(cityName: String): Call<WeatherRemote> {
        return RetrofitFactory.instance.weatherService.getWeatherData(RetrofitFactory.apiKey, cityName, RetrofitFactory.lang)
    }
}