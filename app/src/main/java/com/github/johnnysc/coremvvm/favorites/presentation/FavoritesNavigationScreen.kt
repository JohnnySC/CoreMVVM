package com.github.johnnysc.coremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.github.johnnysc.coremvvm.presentation.ShowStrategy

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesNavigationScreen : NavigationScreen(
    "FavoritesNavigationScreen",
    FavoritesFragment::class.java,
    ShowStrategy.REPLACE
)