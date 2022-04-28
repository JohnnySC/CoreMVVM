package com.github.johnnysc.coremvvm.favorites.data

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCache
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesUi

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoritesRepository : ChangeFavorite {

    fun favoritesList(): FavoritesUi

    class Base(
        private val cache: CurrenciesCache.Read,
        private val changeFavorite: ChangeFavorite,
        private val mapper: FavoriteMapper
    ) : FavoritesRepository {

        override fun favoritesList(): FavoritesUi {
            val list = cache.read().map(mapper)
            return FavoritesUi.Base(list)
        }

        override fun changeFavorite(id: String) = changeFavorite.changeFavorite(id)
    }
}