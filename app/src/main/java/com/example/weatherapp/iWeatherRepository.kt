package com.example.weatherapp

import androidx.lifecycle.MutableLiveData

interface iWeatherRepository {
    suspend fun getWeatherDataFromAPI(): MutableLiveData<String>
}