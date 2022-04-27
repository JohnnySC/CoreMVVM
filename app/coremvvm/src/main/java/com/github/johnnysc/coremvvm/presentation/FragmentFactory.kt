package com.github.johnnysc.coremvvm.presentation

import androidx.fragment.app.FragmentManager
import java.lang.IllegalStateException

/**
 * @author Asatryan on 25.04.2022
 */
interface FragmentFactory {

    fun fragment(navigationScreen: NavigationScreen)

    class Error : FragmentFactory {
        override fun fragment(navigationScreen: NavigationScreen) =
            throw IllegalStateException("no matches found for screen: $navigationScreen")
    }

    abstract class Abstract(
        private val containerId: Int,
        private val fragmentManager: FragmentManager,
        private val fragmentFactory: FragmentFactory = Error()
    ) : FragmentFactory {

        protected abstract val screens: List<NavigationScreen>

        override fun fragment(navigationScreen: NavigationScreen) {
            val found: NavigationScreen? = screens.find {
                it.matches(navigationScreen)
            }
            if (found == null)
                fragmentFactory.fragment(navigationScreen)
            else
                found.show(containerId, fragmentManager)
        }
    }
}