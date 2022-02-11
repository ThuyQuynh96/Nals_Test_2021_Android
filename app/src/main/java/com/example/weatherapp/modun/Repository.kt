package com.example.weatherapp.modun

import com.example.weatherapp.data.Dates
import com.example.weatherapp.extenstion.FlowResult
import com.example.weatherapp.extenstion.doOnSuccess
import com.example.weatherapp.extenstion.safeFlow
import com.example.weatherapp.extenstion.transformToLocal
import com.example.weatherapp.modun.local.DateDao
import com.example.weatherapp.modun.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dataLocalSource: DateDao
) {

    fun getDataCity(date: String): Flow<FlowResult<MutableList<Dates>>> = safeFlow {
        dataSource.getDataDate(date)
    }.doOnSuccess {
        dataLocalSource.save(it)
    }.transformToLocal {
        dataLocalSource.getDates()
    }
}
