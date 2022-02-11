package com.example.weatherapp.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.container.tab.ContainerTabFragment
import com.example.weatherapp.databinding.FragmentContainerBinding

class BaseContainerFragment : BaseFragment() {

    private lateinit var binding: FragmentContainerBinding
    private val adapter: BaseContainerAdapter by lazy {
        BaseContainerAdapter(childFragmentManager, level, fragments)
    }

    private val fragments: MutableList<Fragment> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContainerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragments()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onBindViewModel() {
    }

    private fun initViews() {
        binding.apply {
            vpContainer.apply {
                adapter = this@BaseContainerFragment.adapter
                offscreenPageLimit = EPageContainer.values().size
            }
            bottomNavigation.apply {
                setOnNavigationItemSelectedListener {
                    vpContainer.currentItem = it.order
                    true
                }
            }
        }
    }

    private fun initFragments() {
        EPageContainer.values().forEachIndexed { index, _ ->
            fragments.add(ContainerTabFragment.newInstance(index))
        }
    }
}