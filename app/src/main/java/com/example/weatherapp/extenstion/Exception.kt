package com.example.weatherapp.extenstion

import com.example.weatherapp.data.model.BaseError
import com.example.weatherapp.data.model.DefaultError
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.toError(): BaseError {
    return when (this) {
        is SocketTimeoutException -> DefaultError()
        is UnknownHostException -> DefaultError()
        is ConnectException -> DefaultError()
        else -> DefaultError()
    }
}