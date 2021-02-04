package com.example.weatherapp.domain.repositories

import com.example.weatherapp.data.models.WeatherRemote
import com.example.weatherapp.data.network.RetrofitFactory
import com.example.weatherapp.domain.constants.Constants
import retrofit2.Call

class WeatherRepository : iWeatherRepository {
    override suspend fun getWeatherDataFromAPI(cityName: String): Call<WeatherRemote> {
        return RetrofitFactory.instance.weatherService.getWeatherData(Constants.appid, cityName)
    }
}