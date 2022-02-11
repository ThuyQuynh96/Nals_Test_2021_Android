package com.example.weatherapp.extenstion

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.weatherapp.base.BaseFragment

internal fun AppCompatActivity.replaceFragment(
    @IdRes containerId: Int, fragment: BaseFragment,
    t: (transaction: FragmentTransaction) -> Unit = {},
    isAddBackStack: Boolean = false
) {
    if (supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = supportFragmentManager.beginTransaction()
        t.invoke(transaction)
        transaction.replace(containerId, fragment, fragment.javaClass.simpleName)
        if (isAddBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commitAllowingStateLoss()
    }
}