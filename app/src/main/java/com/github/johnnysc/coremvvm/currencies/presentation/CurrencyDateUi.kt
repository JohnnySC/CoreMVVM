package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
class CurrencyDateUi(private val text: String) : ItemUi {

    override fun type(): Int = 2

    override fun show(vararg views: MyView) = views[0].show(text)

    override fun id(): String = text

    override fun content(): String = text
}