package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.CompareContent
import com.github.johnnysc.coremvvm.presentation.adapter.CompareId
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
data class CurrencyUi(
    private val id: String,
    private val text: String,
    private val isFavorite: Boolean,
    private val changeFavorite: ChangeFavorite,
    private val clickable: Boolean
) : ItemUi {

    override fun type() = if (clickable) CurrencyTypeClickable else CurrencyType

    override fun show(vararg views: MyView) {
        views[0].show(text)
        views[1].check(isFavorite)
        views[1].handleClick {
            changeFavorite.changeFavorite(id)
        }
    }

    override fun same(compareId: CompareId): Boolean = compareId.sameId(id)

    override fun sameId(id: String) = this.id == id

    override fun sameContent(compareContent: CompareContent) =
        compareContent.sameContent(text + isFavorite)

    override fun sameContent(content: String) = text + isFavorite == content

}