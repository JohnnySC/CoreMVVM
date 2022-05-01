package com.github.johnnysc.coremvvm.presentation

import androidx.fragment.app.FragmentManager

/**
 * @author Asatryan on 25.04.2022
 */
abstract class ShowStrategy {

    abstract fun show(
        id: String,
        clasz: Class<out BaseFragment<*>>,
        containerId: Int,
        fragmentManager: FragmentManager
    )

    object ADD : ShowStrategy() {
        override fun show(
            id: String,
            clasz: Class<out BaseFragment<*>>,
            containerId: Int,
            fragmentManager: FragmentManager
        ) {
            fragmentManager.beginTransaction()
                .add(containerId, clasz.newInstance())
                .addToBackStack(id)
                .commit()
        }
    }

    object REPLACE : ShowStrategy() {
        override fun show(
            id: String,
            clasz: Class<out BaseFragment<*>>,
            containerId: Int,
            fragmentManager: FragmentManager
        ) {
            fragmentManager.beginTransaction()
                .replace(containerId, clasz.newInstance())
                .commit()
        }
    }

    object POPUP : ShowStrategy() {
        override fun show(
            id: String,
            clasz: Class<out BaseFragment<*>>,
            containerId: Int,
            fragmentManager: FragmentManager
        ) = fragmentManager.popBackStack()
    }
}