package com.example.weatherapp.extenstion

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment

internal fun Fragment.addChildFragment(
    @IdRes containerId: Int, fragment: BaseFragment, backStack: String? = null,
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    if (childFragmentManager.findFragmentByTag(backStack) == null) {
        val transaction = childFragmentManager.beginTransaction()
        t.invoke(transaction)
        transaction.add(containerId, fragment, fragment.javaClass.name)
        if (backStack != null) {
            transaction.addToBackStack(backStack)
        }
        transaction.commitAllowingStateLoss()
    }
}

internal fun Fragment.replaceChildFragment(
    @IdRes containerId: Int, fragment: BaseFragment, backStack: String? = null,
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    val transaction = childFragmentManager.beginTransaction()
    t.invoke(transaction)
    transaction.replace(containerId, fragment, backStack)
    if (backStack != null) {
        transaction.addToBackStack(backStack)
    }
    transaction.commit()
}

internal fun FragmentTransaction.animSlideInRightSlideOutRight() {
    setCustomAnimations(R.anim.slide_in_right, 0, 0, R.anim.slide_out_right)
}

internal fun FragmentTransaction.animSlideOutRight() {
    setCustomAnimations(R.anim.nothing, 0, 0, R.anim.slide_out_right)
}

internal fun FragmentTransaction.animSlideInUpSlideOutUp() {
    setCustomAnimations(R.anim.slide_in_up, 0, 0, R.anim.slide_out_up)
}