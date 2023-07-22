package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.CompareContent
import com.github.johnnysc.coremvvm.presentation.adapter.CompareId
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
data class CurrencyUi(
    private val id: String,
    private val text: String,
    private val isFavorite: Boolean,
    private val clickable: Boolean
) : CurrencyItemUi {

    override fun type() = if (clickable) CurrencyTypeCombo.Clickable else CurrencyTypeCombo.Base

    override fun show(vararg views: MyView) {
        views[0].show(text)
        views[1].check(isFavorite)
    }

    override fun handleClick(clickListener: CurrenciesClickListener) =
        clickListener.changeFavorite(id)

    override fun same(compareId: CompareId): Boolean = compareId.sameId(id)

    override fun sameId(id: String) = this.id == id

    override fun sameContent(compareContent: CompareContent) =
        compareContent.sameContent(text + isFavorite)

    override fun sameContent(content: String) = text + isFavorite == content

}