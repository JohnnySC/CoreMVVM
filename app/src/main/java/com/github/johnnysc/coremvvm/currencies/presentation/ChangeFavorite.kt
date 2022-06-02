package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.favorites.presentation.UpdateFavorites

/**
 * @author Asatryan on 26.04.2022
 */
interface ChangeFavorite {

    fun changeFavorite(id: String)

    class Combo(
        private val changeFavorite: ChangeFavorite,
        private val communication: UpdateFavorites.Update
    ) : ChangeFavorite {

        override fun changeFavorite(id: String) {
            changeFavorite.changeFavorite(id)
            communication.map(true)
        }
    }
}