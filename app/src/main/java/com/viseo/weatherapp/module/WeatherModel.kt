package com.viseo.weatherapp.module

data class WeatherModel(
    var coord: Coords?,
    var weather: List<Weather>,
    var base: String? = null,
    var main: Main? = null,
    var visibility: Int = 0,
    var id: Int = 0,
    var name: String? = null,
    var cod: Long = 0
)

data class Coords(
    var log: Double = 0.0,
    var lat: Double = 0.0
)

data class Weather(
    var id: Int = 0,
    var icon: String? = null,
    var main: String? = null,
    var description: String? = null
)


data class Main(
    var temp: Double = 0.0,
    var pressure: Double = 0.0,
    var humidity: Double = 0.0,
    var temp_min: Double = 0.0,
    var temp_max: Double = 0.0
)
