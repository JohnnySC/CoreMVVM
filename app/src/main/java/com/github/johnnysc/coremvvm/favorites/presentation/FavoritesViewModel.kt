package com.github.johnnysc.coremvvm.favorites.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesClickListener
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesUi
import com.github.johnnysc.coremvvm.favorites.data.FavoritesRepository
import com.github.johnnysc.coremvvm.presentation.BaseViewModel

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesViewModel(
    private val changeFavorite: ChangeFavorite,
    private val update: UpdateFavorites.Observe,
    private val repository: FavoritesRepository,
    communication: FavoritesCommunication,
    dispatchers: Dispatchers
) : BaseViewModel<CurrenciesUi>(
    communication,
    dispatchers
), CurrenciesClickListener {

    init {
        update()
    }

    fun update() = communication.map(repository.favoritesList())

    fun observeUpdate(owner: LifecycleOwner, observer: Observer<Boolean>) =
        update.observe(owner, observer)

    override fun changeFavorite(id: String) = changeFavorite.changeFavorite(id)
}