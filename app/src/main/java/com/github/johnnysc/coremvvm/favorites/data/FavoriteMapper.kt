package com.github.johnnysc.coremvvm.favorites.data

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCloud
import com.github.johnnysc.coremvvm.currencies.data.IsFavorite
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.currencies.presentation.CurrencyUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 28.04.2022
 */
interface FavoriteMapper : CurrenciesCloud.Mapper<List<ItemUi>> {

    class Base(
        private val isFavorite: IsFavorite,
        private val changeFavorite: ChangeFavorite
    ) : FavoriteMapper {

        override fun map(
            base: String,
            date: String,
            currencies: Map<String, Double>
        ): List<ItemUi> {
            val filteredList = currencies.map { Pair(it.key, it.value) }.toList()
                .filter { isFavorite.isFavorite(it.first) }
            return filteredList.map {
                CurrencyUi(
                    it.first,
                    "$base/${it.first}: ${it.second}",
                    true,
                    changeFavorite,
                    false
                )
            }
        }
    }
}