package com.github.johnnysc.coremvvm.favorites.data

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCache
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesUi

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoritesRepository {

    fun favoritesList(): CurrenciesUi

    class Base(
        private val cache: CurrenciesCache.Read,
        private val mapper: FavoriteMapper
    ) : FavoritesRepository {

        override fun favoritesList(): CurrenciesUi {
            val list = cache.read().map(mapper)
            return CurrenciesUi.Base(list)
        }
    }
}