package com.example.mydemosample

import com.example.basicdemo.module.CitiesWeatherModel
import com.example.basicdemo.utils.Constants
import com.viseo.weatherapp.module.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestData {

    val retrofit = RetrofitClientInstance.getRetrofitInstance()
    val api = retrofit.create(Api::class.java)


    fun getCityDetails(onSuccess: (CitiesWeatherModel) -> Unit) {
        val call = api.getWeatherForAllCountries(Constants.DEFAULT_COUNTRYCODES, Constants.API_KEY)
        call?.enqueue(object : Callback<CitiesWeatherModel> {
            override fun onResponse(
                call: Call<CitiesWeatherModel>,
                response: Response<CitiesWeatherModel>
            ) {
                response.body()?.let { onSuccess(it) }
            }

            override fun onFailure(call: Call<CitiesWeatherModel>, t: Throwable) {

            }
        })
    }

    fun getWeatherdetails(cityName: String, onSuccess: (WeatherModel) -> Unit) {
        val call = api.getWeatherDataByCityCode(cityName, Constants.API_KEY)
        call?.enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let { onSuccess(it) }
            }
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
            }
        })
    }
}