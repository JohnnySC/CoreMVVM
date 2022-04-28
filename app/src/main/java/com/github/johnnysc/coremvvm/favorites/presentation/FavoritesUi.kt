package com.github.johnnysc.coremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.core.Mapper
import com.github.johnnysc.coremvvm.currencies.presentation.CurrencyUi

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoritesUi {

    fun apply(mapper: Mapper.Unit<List<CurrencyUi>>)

    abstract class Abstract(
        private val list: List<CurrencyUi>
    ) : FavoritesUi {

        override fun apply(mapper: Mapper.Unit<List<CurrencyUi>>) = mapper.map(list)
    }

    class Base(list: List<CurrencyUi>) : Abstract(list), FavoritesUi
}