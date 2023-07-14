package com.github.johnnysc.coremvvm.currencies.domain

import com.github.johnnysc.coremvvm.currencies.data.FavoritesCacheDataSource
import com.github.johnnysc.coremvvm.currencies.presentation.*
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 24.04.2022
 */
interface CurrenciesDomain {

    fun <T> map(mapper: Mapper<T>): T

    class Base(
        private val base: String,
        private val date: String,
        private val list: List<Pair<String, Double>>
    ) : CurrenciesDomain {

        override fun <T> map(mapper: Mapper<T>) = mapper.map(base, date, list)
    }

    interface Mapper<T> {
        fun map(base: String, date: String, list: List<Pair<String, Double>>): T

        class Base(
            private val cacheDataSource: FavoritesCacheDataSource,
            private val changeFavorite: ChangeFavorite
        ) : Mapper<CurrenciesUi> {
            override fun map(
                base: String,
                date: String,
                list: List<Pair<String, Double>>
            ): CurrenciesUi {
                val finalList = mutableListOf<ItemUi>(CurrencyDateUi("Last update: $date", true))
                finalList.addAll(list.map {
                    CurrencyUi(
                        it.first, "$base/${it.first}: ${it.second}",
                        cacheDataSource.isFavorite(it.first), changeFavorite, true
                    )
                })
                return CurrenciesUi.Base(finalList)
            }
        }
    }
}