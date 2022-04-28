package com.github.johnnysc.coremvvm.main.presentation

import androidx.fragment.app.FragmentManager
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesNavigationScreen
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesNavigationScreen
import com.github.johnnysc.coremvvm.presentation.FragmentFactory
import com.github.johnnysc.coremvvm.presentation.NavigationScreen

/**
 * @author Asatryan on 25.04.2022
 */
class BaseFragmentFactory(
    containerId: Int,
    fragmentManager: FragmentManager,
) : FragmentFactory.Abstract(
    containerId,
    fragmentManager,
) {

    override val screens: List<NavigationScreen> = listOf(
        CurrenciesNavigationScreen(),
        FavoritesNavigationScreen()
    )
}