package com.example.mydemosample


import com.example.basicdemo.module.CitiesWeatherModel
import com.viseo.weatherapp.module.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    /*
     * Returns data based on the country and city name
     */
    @GET("/data/2.5/weather")
    fun getWeatherDataByCityCode(@Query("q") q: String?, @Query("appid") appId: String?): Call<WeatherModel>

    /*
     * Returns all the data for given countries
     */
    @GET("/data/2.5/group")
    fun getWeatherForAllCountries(@Query("id") id: String?, @Query("appid") appid: String?): Call<CitiesWeatherModel>


}