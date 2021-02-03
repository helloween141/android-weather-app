package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: WeatherViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider.AndroidViewModelFactory(this.application)
            .create(WeatherViewModel::class.java)

        button.setOnClickListener{
            viewModel.setCity(et_cityName.text.toString())
        }

        viewModel.getCity().observe(this, {
            tv_city.text = it
        })

        viewModel.getWeatherData().observe(this, {
            tv_degreeValue.setText("$it \u2103")
        })
    }
}