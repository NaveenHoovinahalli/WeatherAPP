package com.example.basicdemo.di

import com.example.basicdemo.ui.WeatherDetailsViewModel
import com.example.mydemosample.MainActivityViewModel
import com.example.mydemosample.RequestData
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { RequestData() }

    viewModel { MainActivityViewModel(get()) }
    viewModel { WeatherDetailsViewModel(get()) }
}