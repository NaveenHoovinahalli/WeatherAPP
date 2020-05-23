package com.viseo.weatherapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import android.widget.Filter
import com.example.mydemosample.MainActivityViewModel
import com.viseo.weatherapp.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import java.util.*
import kotlin.collections.ArrayList

class CityListAdapter(
    var mContext: Context,
    var myViewModel: MainActivityViewModel, private var countryList: ArrayList<String>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var countryFilterList = ArrayList<String>()

    lateinit var mcontext: Context

    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        countryFilterList = countryList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val countryListView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        val sch = CountryHolder(countryListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return countryFilterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.select_country_text.text = countryFilterList[position]

        holder.itemView.setOnClickListener {
            myViewModel.setItemClick(countryFilterList[position])
        }
    }

    private val clickListener = { hero: String ->
        {
            myViewModel.setItemClick(hero)
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    countryFilterList = countryList
                } else {
                    val resultList = ArrayList<String>()
                    for (row in countryList) {
                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    countryFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }

}
