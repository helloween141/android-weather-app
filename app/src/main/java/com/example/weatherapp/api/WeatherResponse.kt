package com.example.weatherapp.api

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("weather")
    var weather = ArrayList<Weather>()

    @SerializedName("main")
    var main = Main()
}

class Weather {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("main")
    var main: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("icon")
    var icon: String? = null
}

class Main {
    @SerializedName("temp")
    var temp = 0f

    @SerializedName("humidity")
    var humidity = 0f

    @SerializedName("pressure")
    var pressure = 0f

    @SerializedName("temp_min")
    var temp_min = 0f

    @SerializedName("temp_max")
    var temp_max = 0f
}
