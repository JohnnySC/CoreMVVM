package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.CompareContent
import com.github.johnnysc.coremvvm.presentation.adapter.CompareId
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
data class CurrencyDateUi(
    private val text: String,
    private val clickable: Boolean
) : CurrencyItemUi {

    override fun type() =
        if (clickable) CurrencyDateTypeCombo.Clickable else CurrencyDateTypeCombo.Base

    override fun show(vararg views: MyView) = views[0].show(text)

    override fun same(compareId: CompareId): Boolean = compareId.sameId(text)

    override fun sameId(id: String) = this.text == id

    override fun sameContent(compareContent: CompareContent) = compareContent.sameContent(text)

    override fun sameContent(content: String) = text == content
}