package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesAdapter {

    class Currencies : GenericAdapter.Base(listOf(CurrencyType, CurrencyDateType))

    class Favorites : GenericAdapter.Base(listOf(CurrencyType))
}