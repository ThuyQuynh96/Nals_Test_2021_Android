package com.example.weatherapp.container

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.weatherapp.base.BaseFragment

@Suppress("DEPRECATION")
class BaseContainerAdapter(
    fm: FragmentManager,
    private val levelParent: Int,
    private val fragments: MutableList<Fragment>
) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = 3

    // Sparse array to keep track of registered fragments in memory
    private val registeredFragments = SparseArray<Fragment>()

    // Register the fragment when the item is instantiated
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as BaseFragment
        fragment.apply {
            setLevel(levelParent + 1)
        }
        registeredFragments.put(position, fragment)
        return fragment
    }

    // Unregister when the item is inactive
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    // Returns the fragment for the position (if instantiated)
    fun getRegisteredFragment(position: Int): Fragment? {
        return registeredFragments.get(position)
    }
}

enum class EPageContainer(val value: Int) {
    PAGE1(0),
    PAGE2(1),
    PAGE3(2)
}