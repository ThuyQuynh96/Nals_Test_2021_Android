package com.example.weatherapp.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    internal var level: Int = 0
        private set

    internal fun setLevel(level: Int) {
        this.level = level
    }

    private var callBackWhenBackPress: OnBackPressedCallback = object : OnBackPressedCallback(
        false
        /** true means that the callback is enabled */
    ) {
        override fun handleOnBackPressed() {
            handleBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // note that you could enable/disable the callback here as well by setting callback.isEnabled = true/false
        requireActivity().onBackPressedDispatcher.addCallback(this, callBackWhenBackPress)
    }

    private fun handleAddCallBack(isEnable: Boolean = true) {
        callBackWhenBackPress.isEnabled = isEnable
    }

    override fun onPause() {
        super.onPause()
        handleAddCallBack(false)
    }

    protected open fun handleBackPressed() {

    }

    override fun onResume() {
        super.onResume()
        handleAddCallBack(true)
        onBindViewModel()
    }

    abstract fun onBindViewModel()
}
