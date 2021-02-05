package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
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
            et_cityName.setText("")
            tv_temp.setText("")
        }

        viewModel.getCity().observe(this, {
            tv_city.text = it
            viewModel.fetchWeatherData(it)
        })

        viewModel.getWeatherData().observe(this, {
            tv_temp.text = it
        })

        viewModel.getLoaderStatus().observe(this, {
            if (it) {
                loader.visibility = View.VISIBLE
            } else {
                loader.visibility = View.GONE
            }
        })
    }
}