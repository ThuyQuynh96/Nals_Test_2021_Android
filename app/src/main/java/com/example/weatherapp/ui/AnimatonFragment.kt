package com.example.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.databinding.FragmentAnimationBinding

class AnimatonFragment : BaseFragment() {

    private lateinit var binding: FragmentAnimationBinding
    override fun onBindViewModel() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimationBinding.inflate(layoutInflater)
        return binding.root
    }
}
