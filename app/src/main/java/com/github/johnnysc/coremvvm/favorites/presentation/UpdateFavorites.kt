package com.github.johnnysc.coremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

/**
 * @author Asatryan on 02.06.2022
 */
interface UpdateFavorites {

    interface Observe : Communication.Observe<Boolean>
    interface Update : Communication.Update<Boolean>

    class Base : Communication.SingleUiUpdate<Boolean>(), Observe, Update
}