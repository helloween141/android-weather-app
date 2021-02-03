package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.api.RetrofitClient
import com.example.weatherapp.api.WeatherResponse
import com.example.weatherapp.api.iWeatherService
import com.example.weatherapp.constants.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {
    private var weatherLiveData: MutableLiveData<String> = MutableLiveData()
    private val service = RetrofitClient.client.create(iWeatherService::class.java)
    private val call = service.getCurrentWeatherData(Constants.appid, "Moscow")

    fun getWeatherDataFromAPI(): MutableLiveData<String> {

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    weatherLiveData.value = weatherResponse.main.temp.toString();
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherLiveData.value = "Can't get data from API"
            }
        })
        return  weatherLiveData
    }

}