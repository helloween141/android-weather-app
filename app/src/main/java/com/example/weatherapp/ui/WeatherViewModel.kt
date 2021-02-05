package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.models.WeatherRemote
import com.example.weatherapp.domain.repositories.WeatherRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {
    var cityLiveData: MutableLiveData<String> = MutableLiveData()
    var weatherLiveData: MutableLiveData<String> = MutableLiveData()
    var loaderLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val weatherRepository: WeatherRepository = WeatherRepository()

    fun fetchWeatherData(cityName: String) {
        viewModelScope.launch {
            val data = weatherRepository.getWeatherDataFromAPI(cityName)
            loaderLiveData.value = true
            data.enqueue(object : Callback<WeatherRemote> {
                override fun onResponse(call: Call<WeatherRemote>?, response: Response<WeatherRemote>?) {
                    var result = ""
                    if (response != null) {
                        if (response.body() != null) {
                            val body = response.body()
                            val temperature = Math.round(body.main.temp - 273.15)
                            val weather = body.weather[0].description
                            result = "$temperature ℃, $weather"
                        } else {
                            result = "Нет данных по городу"
                        }
                    } else {
                        result = "Нет данных по городу"
                    }

                    loaderLiveData.value = false
                    weatherLiveData.postValue(result)
                }

                override fun onFailure(call: Call<WeatherRemote>?, t: Throwable?) {
                    Log.d("API_ERROR", t.toString())
                }

            })

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

    fun getLoaderStatus(): MutableLiveData<Boolean> {
        return loaderLiveData
    }
}
