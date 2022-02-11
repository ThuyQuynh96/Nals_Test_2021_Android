package com.example.weatherapp.modun.network

import com.example.weatherapp.data.Dates

interface RemoteDataSource {
    suspend fun getDataDate(city : String): MutableList<Dates>
}