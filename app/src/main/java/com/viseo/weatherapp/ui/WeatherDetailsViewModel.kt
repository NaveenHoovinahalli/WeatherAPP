package com.example.basicdemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydemosample.RequestData
import com.viseo.weatherapp.module.WeatherModel

class WeatherDetailsViewModel(val requestServer: RequestData) : ViewModel() {

    var weatherDetails = MutableLiveData<WeatherModel>()

    fun getDetailsWeather(cityName: String){
        requestServer.getWeatherdetails(cityName) {
            it.let { it -> weatherDetails.value = it }
        }
    }

}