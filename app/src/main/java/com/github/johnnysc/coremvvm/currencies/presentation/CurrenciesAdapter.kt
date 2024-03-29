package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ClickListener
import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesAdapter {

    class Currencies(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, MyView,  CurrencyItemUi>(
        clickListener,
        listOf(CurrencyTypeCombo.Clickable, CurrencyDateTypeCombo.Base)
    )

    class Favorites(
        clickListener: CurrenciesClickListener,
    ) : GenericAdapter.Combo<CurrenciesClickListener, MyView, CurrencyItemUi>(
        clickListener,
        listOf(CurrencyTypeCombo.Base, CurrencyTypeCombo.Clickable)
    )
}

interface CurrenciesClickListener : ChangeFavorite, ClickListener