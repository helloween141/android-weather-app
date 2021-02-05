package com.example.weatherapp.data.network

import com.example.weatherapp.data.services.WeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        val instance = RetrofitFactory()
        const val apiKey = "d800a1a3a4dff5e3f9e9172d76d9e249"
        const val baseUrl = "https://api.openweathermap.org/"
        const val lang = "ru"
    }

    private fun okHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(okHttpInterceptor()).build()

    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofitClient.create(WeatherService::class.java)
}
