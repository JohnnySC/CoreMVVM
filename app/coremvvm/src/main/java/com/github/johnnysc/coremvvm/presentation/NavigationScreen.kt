package com.github.johnnysc.coremvvm.presentation

import androidx.fragment.app.FragmentManager
import com.github.johnnysc.coremvvm.core.Matches

/**
 * @author Asatryan on 25.04.2022
 */
abstract class NavigationScreen(
    private val id: String,
    private val clasz: Class<out BaseFragment<*>>,
    private val strategy: ShowStrategy
) : Matches<NavigationScreen>, ShowScreen {

    override fun matches(data: NavigationScreen): Boolean = data.id == this.id

    override fun toString(): String = "id $id"

    override fun show(containerId: Int, fragmentManager: FragmentManager) =
        strategy.show(id, clasz, containerId, fragmentManager)
}