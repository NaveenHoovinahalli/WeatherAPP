package com.viseo.weatherapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.basicdemo.ui.WeatherDetailsViewModel
import com.example.basicdemo.utils.Constants
import com.viseo.weatherapp.module.WeatherModel
import kotlinx.android.synthetic.main.details_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
* Display selected city details */
class DetailsActivity :BaseActivity() {

    companion object {
         const val CITY_KEY = "CITY"
        fun start(context: Context, cityName : String) {
            val detailsActivityIntent = Intent(context, DetailsActivity::class.java)
            detailsActivityIntent.putExtra(CITY_KEY, cityName)
            context.startActivity(detailsActivityIntent)
        }
    }

    val myViewModel: WeatherDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detiails)
        var name = intent.getStringExtra(CITY_KEY)
        myViewModel.getDetailsWeather(name)
        setObserver()
    }

    private fun setObserver() {

        myViewModel.weatherDetails.observe(this, Observer {
            it?.let {
                updateView(it)
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    fun updateView(it: WeatherModel) {
        tv_temp.append(it.main?.temp.toString())
        tv_weather.append(it.weather[0].description)
        tv_humidity.append(it.main?.humidity.toString())
        tv_city.text = it.name
        setImage(it)
    }

    fun setImage(it: WeatherModel) {
        val imageUri: String = Constants.IMAGE_URL.toString() + it.weather[0].icon + ".png"
        Glide.with(this)
            .load(imageUri)
            .into(weather_icon)
    }
}