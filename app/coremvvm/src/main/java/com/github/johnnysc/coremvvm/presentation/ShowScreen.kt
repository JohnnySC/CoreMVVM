package com.github.johnnysc.coremvvm.presentation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

/**
 * @author Asatryan on 25.04.2022
 */
interface ShowScreen {

    fun show(
        @IdRes containerId: Int,
        fragmentManager: FragmentManager
    )
}