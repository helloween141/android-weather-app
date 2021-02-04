package com.example.weatherapp.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.data.models.WeatherRemote
import retrofit2.Call

interface iWeatherRepository {
    suspend fun getWeatherDataFromAPI(cityName: String): Call<WeatherRemote>
}