package com.github.johnnysc.coremvvm.currencies.data

import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.favorites.data.FavoriteCurrencies

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoritesCacheDataSource : ChangeFavorite, IsFavorite {

    class Base(private val favorites: FavoriteCurrencies.Mutable) : FavoritesCacheDataSource {

        private var cached = favorites.read()

        override fun changeFavorite(id: String) {
            val data = cached.toMutableSet()
            if (isFavorite(id))
                data.remove(id)
            else
                data.add(id)
            favorites.save(data)
            cached = favorites.read()
        }

        override fun isFavorite(id: String) = cached.contains(id)
    }
}