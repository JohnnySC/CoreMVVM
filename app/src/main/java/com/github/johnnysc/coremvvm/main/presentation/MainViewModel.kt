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
    private val navigationCommunication: NavigationCommunication.Mutable,
    private val progressCommunication: ProgressCommunication.Mutable,
    dispatchers: Dispatchers,
    communication: GlobalErrorCommunication.Mutable
) : BaseViewModel<String>(
    communication,
    dispatchers
) {

    private val currenciesNavigationScreen = CurrenciesNavigationScreen()
    private val favoritesNavigationScreen = FavoritesNavigationScreen()

    init {
        chooseTab(true)
    }

    fun observeNavigation(owner: LifecycleOwner, observer: Observer<NavigationScreen>) {
        navigationCommunication.observe(owner, observer)
    }

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Visibility>) {
        progressCommunication.observe(owner, observer)
    }

    fun chooseTab(listTabChosen: Boolean) = navigationCommunication.map(
        if (listTabChosen) currenciesNavigationScreen else favoritesNavigationScreen
    )
}