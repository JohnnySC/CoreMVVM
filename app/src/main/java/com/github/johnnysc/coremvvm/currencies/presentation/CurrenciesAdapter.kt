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
    ) : GenericAdapter.WithClicks<CurrenciesClickListener, ItemUi>(
        clickListener,
        ItemUiTypeList.WithClickListener(listOf(CurrencyTypeClickable, CurrencyDateTypeClickable))
    )

    class Favorites: GenericAdapter.Simple<ItemUi>(ItemUiTypeList.Base(listOf(CurrencyType)))
}

interface CurrenciesClickListener : ClickListener {
    fun show(currency: String)
}