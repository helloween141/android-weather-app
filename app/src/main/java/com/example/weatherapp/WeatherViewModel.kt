package com.example.weatherapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    var cityLiveData: MutableLiveData<String> = MutableLiveData()
    var weatherLiveData: MutableLiveData<String> = MutableLiveData()
    val weatherRepository: WeatherRepository = WeatherRepository()

    fun getWeatherData(): MutableLiveData<String> {
        weatherLiveData = weatherRepository.getWeatherDataFromAPI()
        return weatherLiveData
    }

    fun getCity(): MutableLiveData<String> {
        return cityLiveData
    }

    fun setCity(cityName: String) {
        cityLiveData.value = cityName
    }
}