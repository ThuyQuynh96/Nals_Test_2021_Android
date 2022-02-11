package com.example.weatherapp.base

import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.model.BaseError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel(), BaseVMContact {
    private var loadingState = MutableStateFlow(false)
    private var errorState = MutableStateFlow<BaseError?>(null)

    override fun loadingState(): StateFlow<Boolean> = loadingState

    override fun errorState(): StateFlow<BaseError?> = errorState

    override fun handleError(error: BaseError?) {
        errorState.value = error
    }

    override fun handleLoading(isLoading: Boolean) {
        loadingState.value = isLoading
    }
}