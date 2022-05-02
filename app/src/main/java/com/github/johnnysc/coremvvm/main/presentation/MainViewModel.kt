package com.github.johnnysc.coremvvm.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesNavigationScreen
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesNavigationScreen
import com.github.johnnysc.coremvvm.presentation.*

/**
 * @author Asatryan on 24.04.2022
 */
class MainViewModel(
    canGoBack: CanGoBack,
    private val navigationCommunication: NavigationCommunication.Mutable,
    private val progressCommunication: ProgressCommunication.Mutable,
    dispatchers: Dispatchers,
    communication: GlobalErrorCommunication.Mutable
) : BackPress.Activity.ViewModel<String>(
    canGoBack,
    communication,
    dispatchers
) {

    private val currenciesNavigationScreen = CurrenciesNavigationScreen()
    private val favoritesNavigationScreen = FavoritesNavigationScreen()

    init {
        chooseTab(0)
    }

    fun observeNavigation(owner: LifecycleOwner, observer: Observer<NavigationScreen>) {
        navigationCommunication.observe(owner, observer)
    }

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Visibility>) {
        progressCommunication.observe(owner, observer)
    }

    fun chooseTab(tabPosition: Int) = navigationCommunication.map(
        if (tabPosition == 0) currenciesNavigationScreen else favoritesNavigationScreen
    )
}