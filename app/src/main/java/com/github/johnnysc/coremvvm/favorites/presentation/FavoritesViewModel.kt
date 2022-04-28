package com.github.johnnysc.coremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.favorites.data.FavoritesRepository
import com.github.johnnysc.coremvvm.presentation.BaseViewModel

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesViewModel(
    private val repository: FavoritesRepository,
    communication: FavoritesCommunication,
    dispatchers: Dispatchers
) : BaseViewModel<FavoritesUi>(
    communication,
    dispatchers
), ChangeFavorite {

    init {
        communication.map(repository.favoritesList())
    }

    override fun changeFavorite(id: String) {
        repository.changeFavorite(id)
        communication.map(repository.favoritesList())
    }
}