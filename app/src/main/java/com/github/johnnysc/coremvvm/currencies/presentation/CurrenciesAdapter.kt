package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ClickListener
import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiTypeList

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesAdapter {

    class Currencies(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, ItemUi>(
        clickListener,
        ItemUiTypeList.Combo(listOf(CurrencyTypeCombo.Clickable, CurrencyDateTypeCombo.Base))
    )

    class Favorites(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, ItemUi>(
        clickListener,
        ItemUiTypeList.Combo(listOf(CurrencyTypeCombo.Base, CurrencyTypeCombo.Clickable))
    )
}

interface CurrenciesClickListener : ClickListener {
    fun show(currency: String)
}