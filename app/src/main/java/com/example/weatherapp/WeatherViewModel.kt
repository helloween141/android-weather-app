package com.example.weatherapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var cityLiveData: MutableLiveData<String> = MutableLiveData()
    var weatherLiveData: MutableLiveData<String> = MutableLiveData()
    val weatherRepository: WeatherRepository = WeatherRepository()

    fun fetchWeatherData() {
        viewModelScope.launch {
            val data = weatherRepository.getWeatherDataFromAPI()
            //weatherLiveData.postValue(weatherRepository.getWeatherDataFromAPI().toString())
        }
    }

    fun getWeatherData(): MutableLiveData<String> {
        return weatherLiveData
    }

    fun getCity(): MutableLiveData<String> {
        return cityLiveData
    }

    fun setCity(cityName: String) {
        cityLiveData.value = cityName
    }
}