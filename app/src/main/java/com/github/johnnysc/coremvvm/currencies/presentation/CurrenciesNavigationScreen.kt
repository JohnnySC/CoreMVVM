package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.github.johnnysc.coremvvm.presentation.ShowStrategy

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesNavigationScreen(showStrategy: ShowStrategy = ShowStrategy.REPLACE) :
    NavigationScreen(
        "CurrenciesNavigationScreen",
        CurrenciesFragment::class.java,
        showStrategy
    )