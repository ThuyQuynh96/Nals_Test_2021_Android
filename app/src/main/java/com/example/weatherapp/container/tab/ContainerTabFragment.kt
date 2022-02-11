package com.example.weatherapp.container.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.container.EPageContainer
import com.example.weatherapp.extenstion.replaceChildFragment
import com.example.weatherapp.ui.WeatherFragment

class ContainerTabFragment : BaseFragment() {

    companion object {
        private const val KEY_TAB = "key_tab"
        internal fun newInstance(tab: Int) = ContainerTabFragment().apply {
            arguments = Bundle().apply {
                putInt(KEY_TAB, tab)
            }
        }
    }

    private var currentFragment: Fragment? = null

    override fun onBindViewModel() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_super_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleAddChildFragment()
    }

    private fun handleAddChildFragment() {
        if (currentFragment == null) {
            arguments?.also {
                currentFragment = when (it.getInt(KEY_TAB)) {
                    EPageContainer.PAGE1.value -> {
                        WeatherFragment()
                    }
                    EPageContainer.PAGE2.value -> {
                        WeatherFragment()
                    }
                    EPageContainer.PAGE3.value -> {
                        WeatherFragment()
                    }
                    else -> {
                        null
                    }
                }
            }
            currentFragment?.also {
                replaceChildFragment(R.id.flContainer, WeatherFragment())
            }
        }
    }
}