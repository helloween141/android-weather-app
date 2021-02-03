package com.example.weatherapp.api

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("weather")
    var weather = ArrayList<Weather>()

    @SerializedName("main")
    var main = Main()
}

data class Weather(var id: Int = 0, var main: String? = null, var description: String? = null, var icon: String? = null)

data class Main(var temp: Float = 0f, var humidity: Float = 0f, var pressure: Float = 0f, var temp_min: Float = 0f, var temp_max: Float = 0f)

