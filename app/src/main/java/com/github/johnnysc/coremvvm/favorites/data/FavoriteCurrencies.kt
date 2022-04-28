package com.github.johnnysc.coremvvm.favorites.data

import com.github.johnnysc.coremvvm.data.PreferenceDataStore

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoriteCurrencies {

    interface Save : com.github.johnnysc.coremvvm.core.Save<Set<String>>
    interface Read : com.github.johnnysc.coremvvm.core.Read<Set<String>>

    interface Mutable : Save, Read

    class Base(private val preferences: PreferenceDataStore) : Mutable {

        override fun save(data: Set<String>) = preferences.save(KEY, data)

        override fun read() = preferences.read(KEY)

        companion object {
            private const val KEY = "FavoriteCurrenciesKey"
        }
    }
}