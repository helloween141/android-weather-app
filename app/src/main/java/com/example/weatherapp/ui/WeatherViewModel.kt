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
    private val weatherRepository: WeatherRepository = WeatherRepository()

    fun fetchWeatherData(cityName: String) {
        viewModelScope.launch {
            val data = weatherRepository.getWeatherDataFromAPI(cityName)

            data.enqueue(object : Callback<WeatherRemote> {
                override fun onResponse(call: Call<WeatherRemote>?, response: Response<WeatherRemote>?) {
                    if (response != null) {
                        val body = response.body()
                        val result = "Weather: ${body.weather[0].main}, Temperature: ${body.main.temp}"
                        weatherLiveData.postValue(result)
                    }
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
}
