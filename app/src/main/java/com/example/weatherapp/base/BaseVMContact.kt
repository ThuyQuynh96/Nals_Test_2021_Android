package com.example.weatherapp.base

import com.example.weatherapp.data.model.BaseError
import kotlinx.coroutines.flow.StateFlow

interface BaseVMContact {
    fun loadingState(): StateFlow<Boolean>

    fun errorState(): StateFlow<BaseError?>

    fun handleError(error: BaseError?)

    fun handleLoading(isLoading: Boolean)
}
