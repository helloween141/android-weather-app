package com.example.weatherapp.data.models


data class WeatherRemote(
    var weather: ArrayList<Weather> = ArrayList(),
    var main: Main = Main()
)

data class Weather(
    var id: Int = 0,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)

data class Main(
    var temp: Float = 0f,
    var humidity: Float = 0f,
    var pressure: Float = 0f,
    var temp_min: Float = 0f,
    var temp_max: Float = 0f
)

