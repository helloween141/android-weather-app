package com.example.weatherapp.data.network

import com.example.weatherapp.data.services.WeatherService
import com.example.weatherapp.domain.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        val instance = RetrofitFactory()
    }

    private fun okHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(okHttpInterceptor()).build()

    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService = retrofitClient.create(WeatherService::class.java)
}
