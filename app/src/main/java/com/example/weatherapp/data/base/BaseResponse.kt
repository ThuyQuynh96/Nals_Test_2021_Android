package com.example.weatherapp.data.base

import kotlinx.serialization.SerialName

class BaseResponse {
    @SerialName("message") val message: String? = null
}
