package com.viseo.weatherapp

import com.viseo.weatherapp.adapters.CityListAdapter


import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydemosample.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
* Get the information from the api and display in the list of city
*  */
class MainActivity : AppCompatActivity() {
    lateinit var adapter: CityListAdapter

    val myViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.setLayoutManager(LinearLayoutManager(this))

        myViewModel.fetchData()

        country_search.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (newText.length > 2)
                        adapter.filter.filter(newText)
                    else {
                        adapter.filter.filter("")
                    }
                }
                return false
            }

        })

        setupObservers()

    }

    private fun setupObservers() {

        myViewModel.citiesWeatherModel.observe(this, Observer {
            it?.let {
                adapter = CityListAdapter(
                    this@MainActivity,
                    myViewModel,
                    it.list.map { it.name } as ArrayList<String>)
                recyclerview.setAdapter(adapter)
            }
        })

        myViewModel.myPosition.observe(this, Observer {
            DetailsActivity.start(this, it)

        })
    }
}