package com.example.mydemosample

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicdemo.module.CitiesWeatherModel


class MainActivityViewModel(val requestServer: RequestData) : ViewModel() {
    var myPosition = MutableLiveData<String>()


    var citiesWeatherModel = MutableLiveData<CitiesWeatherModel>()

    fun fetchData() {
        requestServer.getCityDetails {
            citiesWeatherModel.value = it
        }
    }

    fun setItemClick(name: String)  {
        myPosition.value = name
    }
}