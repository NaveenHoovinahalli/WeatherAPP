package com.viseo.weatherapp.di

import android.app.Application

import com.example.basicdemo.di.appModule
import org.junit.After
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

open class BaseTest : KoinTest {
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

    @Before
    open fun before() {
        MockitoAnnotations.initMocks(this)

        startKoin {
            androidContext(Mockito.mock(Application::class.java))
            modules(listOf(appModule))
        }
    }

    @After
    fun after() {
        stopKoin()
    }
}