package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ClickListener
import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesAdapter {

    class Currencies(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, ItemUi>(
        clickListener,
        listOf(CurrencyTypeCombo.Clickable, CurrencyDateTypeCombo.Base)
    )

    class Favorites(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, ItemUi>(
        clickListener,
        listOf(CurrencyTypeCombo.Base, CurrencyTypeCombo.Clickable)
    )
}

interface CurrenciesClickListener : ClickListener {
    fun show(currency: String)
}