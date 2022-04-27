package com.github.johnnysc.coremvvm.data

import android.content.SharedPreferences

/**
 * @author Asatryan on 26.04.2022
 */
interface PreferenceDataStore {

    fun save(key: String, data: Set<String>)

    fun read(key: String): Set<String>

    class Base(private val sharedPreferences: SharedPreferences) : PreferenceDataStore {

        override fun save(key: String, data: Set<String>) =
            sharedPreferences.edit().putStringSet(key, data).apply()

        override fun read(key: String): Set<String> =
            sharedPreferences.getStringSet(key, emptySet()) ?: emptySet()
    }
}