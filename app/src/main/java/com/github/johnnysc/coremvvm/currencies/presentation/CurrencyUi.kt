package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
class CurrencyUi(
    private val id: String,
    private val text: String,
    private val isFavorite: Boolean,
    private val changeFavorite: ChangeFavorite
) : ItemUi {

    override fun type(): Int = 1

    override fun show(vararg views: MyView) {
        views[0].show(text)
        views[1].check(isFavorite)
        views[1].handleClick {
            changeFavorite.changeFavorite(id)
        }
    }

    override fun id(): String = id

    override fun content(): String = text + isFavorite
}