package com.example.weatherapp.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.Dates
import com.example.weatherapp.databinding.ItemWeatherBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherAdapter(private val listDates: List<Dates>) :
    RecyclerView.Adapter<WeatherAdapter.ListViewHolder>() {

    internal var onItemClicked: (position: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding(listDates[position])
    }

    override fun getItemCount(): Int = listDates.size

    inner class ListViewHolder(private val viewBinding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        init {
            viewBinding.llButton.setOnClickListener {
                onItemClicked.invoke(layoutPosition)
            }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun binding(dates: Dates) {
            viewBinding.apply {
                if (dates.applicable_date == LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("m/d"))
                ) {
                    tvName.text = "ToDay"
                    tvDate.visibility = View.GONE
                    llButton.setBackgroundResource(R.color.colorPrimary)
                } else {
                    tvDate.text = dates.applicable_date
                }
            }
        }

    }
}