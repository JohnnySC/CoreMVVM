package com.github.johnnysc.coremvvm.favorites.data

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCloud
import com.github.johnnysc.coremvvm.currencies.data.IsFavorite
import com.github.johnnysc.coremvvm.currencies.presentation.CurrencyUi

/**
 * @author Asatryan on 28.04.2022
 */
interface FavoriteMapper : CurrenciesCloud.Mapper<List<CurrencyUi>> {

    class Base(private val isFavorite: IsFavorite) : FavoriteMapper {
        override fun map(
            base: String,
            date: String,
            currencies: Map<String, Double>
        ): List<CurrencyUi> {
            val filteredList = currencies.map { Pair(it.key, it.value) }.toList()
                .filter { isFavorite.isFavorite(it.first) }
            return filteredList.map {
                CurrencyUi.Base(
                    it.first,
                    "$base/${it.first}: ${it.second}",
                    true
                )
            }
        }
    }
}