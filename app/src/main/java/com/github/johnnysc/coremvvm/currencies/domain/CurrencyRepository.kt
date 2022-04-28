package com.github.johnnysc.coremvvm.currencies.domain

import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite

/**
 * @author Asatryan on 24.04.2022
 */
interface CurrencyRepository : ChangeFavorite {
    suspend fun currencies(): CurrenciesDomain
}