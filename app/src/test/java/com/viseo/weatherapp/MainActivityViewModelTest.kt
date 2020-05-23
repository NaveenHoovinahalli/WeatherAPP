package com.viseo.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.basicdemo.module.CitiesWeatherModel
import com.example.mydemosample.MainActivityViewModel
import com.example.mydemosample.RequestData
import com.viseo.weatherapp.di.BaseTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.mock.declareMock

class MainActivityViewModelTest : BaseTest () {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var  requestData : RequestData
lateinit var mainActivityViewModel : MainActivityViewModel


    @Before
    override fun before() {
        super.before()

        requestData = declareMock()
        mainActivityViewModel = MainActivityViewModel(requestData)
    }


    @Test
    fun setItemClickTest() {
        with(mainActivityViewModel) {
            setItemClick("TestName")
            Assert.assertEquals(myPosition.value,"TestName")
            Assert.assertNotEquals(myPosition.value,"WrongName")
        }
    }

}