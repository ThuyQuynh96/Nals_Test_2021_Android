package com.example.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.data.Dates
import com.example.weatherapp.databinding.FragmentWeatherBinding

class WeatherFragment : BaseFragment() {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var adapter: WeatherAdapter
    private var listDates: List<Dates> = mutableListOf()
    private var position: Int = 0
    override fun onBindViewModel() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViews()
    }

    private fun initAdapter() {
        adapter = WeatherAdapter(listDates)
        binding.apply {
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = adapter
        }
        adapter.onItemClicked = {
            position = it
        }
        adapter.notifyItemChanged(position)
    }

    private fun initViews() {
        binding.apply {
            listDates[position].apply {
                tvCelsius.text = the_temp
                tvText.text = weather_state_name
                tvDay.text = applicable_date
            }
        }
    }
}