package com.example.weatherapp.modun.network

import com.example.weatherapp.data.Dates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("location/1252431/yyyy/mm/dd/")
    suspend fun getDates(@Query("query") query: String): Response<MutableList<Dates>>
}