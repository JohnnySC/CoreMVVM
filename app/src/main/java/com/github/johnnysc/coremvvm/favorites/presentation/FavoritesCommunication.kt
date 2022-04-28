package com.github.johnnysc.coremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

/**
 * @author Asatryan on 26.04.2022
 */
interface FavoritesCommunication : Communication.Mutable<FavoritesUi> {
    class Base : Communication.UiUpdate<FavoritesUi>(), FavoritesCommunication
}